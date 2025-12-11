#!/bin/bash

# Universal Git Repository Setup Script
# This script initializes a git repository, configures user credentials,
# sets up SSH key for authentication, and pushes to GitHub

set -e  # Exit on error

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Function to print colored messages
print_info() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

# Function to display usage
usage() {
    cat << EOF
Usage: $0 [OPTIONS]

Universal Git Repository Setup Script

OPTIONS:
    -u, --username          GitHub username (required)
    -e, --email            Git email address (required)
    -r, --repo             GitHub repository URL (e.g., username/reponame or full git@github.com:username/repo.git)
    -k, --ssh-key          Path to SSH private key (default: ~/.ssh/id_rsa)
    -m, --message          Initial commit message (default: "Initial commit")
    -b, --branch           Branch name (default: master)
    -i, --init             Initialize new git repo (skip if already initialized)
    -p, --push             Push after commit (default: false)
    -h, --help             Display this help message

EXAMPLES:
    # Basic setup with default SSH key
    $0 -u DmytroFedoryshyn -e dimonty2003@gmail.com -r DmytroFedoryshyn/MyCapital

    # Setup with custom SSH key and push
    $0 -u JohnDoe -e john@example.com -r JohnDoe/MyRepo -k ~/.ssh/id_rsa_personal -p

    # Initialize, commit, and push with custom message
    $0 -u JaneDoe -e jane@example.com -r JaneDoe/Project -m "Initial setup" -i -p

EOF
    exit 1
}

# Default values
SSH_KEY="$HOME/.ssh/id_rsa"
COMMIT_MESSAGE="Initial commit"
BRANCH="master"
INIT_REPO=false
PUSH_AFTER=false
USERNAME=""
EMAIL=""
REPO=""

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        -u|--username)
            USERNAME="$2"
            shift 2
            ;;
        -e|--email)
            EMAIL="$2"
            shift 2
            ;;
        -r|--repo)
            REPO="$2"
            shift 2
            ;;
        -k|--ssh-key)
            SSH_KEY="$2"
            shift 2
            ;;
        -m|--message)
            COMMIT_MESSAGE="$2"
            shift 2
            ;;
        -b|--branch)
            BRANCH="$2"
            shift 2
            ;;
        -i|--init)
            INIT_REPO=true
            shift
            ;;
        -p|--push)
            PUSH_AFTER=true
            shift
            ;;
        -h|--help)
            usage
            ;;
        *)
            print_error "Unknown option: $1"
            usage
            ;;
    esac
done

# Validate required parameters
if [ -z "$USERNAME" ]; then
    print_error "Username is required (-u or --username)"
    usage
fi

if [ -z "$EMAIL" ]; then
    print_error "Email is required (-e or --email)"
    usage
fi

if [ -z "$REPO" ]; then
    print_error "Repository is required (-r or --repo)"
    usage
fi

# Validate SSH key exists
if [ ! -f "$SSH_KEY" ]; then
    print_error "SSH key not found at: $SSH_KEY"
    print_info "Available SSH keys:"
    ls -la ~/.ssh/*.pub 2>/dev/null || echo "No public keys found"
    exit 1
fi

print_info "SSH key found: $SSH_KEY"

# Convert short repo format to full SSH URL if needed
if [[ ! "$REPO" =~ ^git@ ]]; then
    # Assume format is username/reponame
    REPO="git@github.com:${REPO}.git"
fi

print_info "Repository URL: $REPO"

# Initialize git repository if requested
if [ "$INIT_REPO" = true ]; then
    if [ -d ".git" ]; then
        print_warning "Git repository already initialized"
    else
        print_info "Initializing git repository..."
        git init
    fi
else
    # Check if already a git repository
    if [ ! -d ".git" ]; then
        print_warning "Not a git repository. Use -i flag to initialize."
        print_info "Initializing git repository..."
        git init
    fi
fi

# Configure git user for this repository
print_info "Configuring git user..."
git config user.name "$USERNAME"
git config user.email "$EMAIL"

# Configure SSH command to use specific key
print_info "Configuring SSH key..."
git config core.sshCommand "ssh -i $SSH_KEY -o IdentitiesOnly=yes"

# Check if remote 'origin' exists
if git remote get-url origin &> /dev/null; then
    print_warning "Remote 'origin' already exists. Updating URL..."
    git remote set-url origin "$REPO"
else
    print_info "Adding remote 'origin'..."
    git remote add origin "$REPO"
fi

# Display configuration
print_info "Git configuration:"
echo "  Username: $USERNAME"
echo "  Email: $EMAIL"
echo "  Remote: $REPO"
echo "  SSH Key: $SSH_KEY"
echo "  Branch: $BRANCH"

# Check if there are any changes to commit
if git diff-index --quiet HEAD -- 2>/dev/null; then
    print_warning "No changes to commit"
else
    print_info "Staging changes..."
    
    # Remove problematic files if they exist (like 'nul' on Windows)
    if [ -f "nul" ]; then
        print_warning "Removing problematic 'nul' file..."
        rm -f nul
    fi
    
    git add .
    
    print_info "Creating commit..."
    git commit -m "$COMMIT_MESSAGE"
fi

# Check if there are any commits
if ! git rev-parse HEAD &> /dev/null; then
    print_warning "No commits yet. Creating initial commit..."
    
    # Remove problematic files
    if [ -f "nul" ]; then
        rm -f nul
    fi
    
    git add .
    git commit -m "$COMMIT_MESSAGE" --allow-empty
fi

# Push if requested
if [ "$PUSH_AFTER" = true ]; then
    print_info "Pushing to remote..."
    
    # Try to push
    if git push -u origin "$BRANCH" 2>&1; then
        print_info "Successfully pushed to $REPO"
    else
        print_error "Failed to push. Please check:"
        echo "  1. The repository exists on GitHub"
        echo "  2. Your SSH key is added to your GitHub account"
        echo "  3. You have write access to the repository"
        echo ""
        echo "To push manually later, run:"
        echo "  git push -u origin $BRANCH"
        exit 1
    fi
else
    print_info "Repository configured. To push, run:"
    echo "  git push -u origin $BRANCH"
fi

print_info "Setup complete!"

