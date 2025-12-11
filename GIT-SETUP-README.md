# Git Setup Script

A universal shell script to configure Git repositories with custom user credentials, SSH keys, and push to GitHub.

## Features

- ✅ Initialize Git repository (optional)
- ✅ Configure repository-specific user name and email
- ✅ Set up custom SSH key for authentication
- ✅ Add or update remote origin
- ✅ Commit changes with custom message
- ✅ Push to GitHub with specified branch
- ✅ Handles Windows-specific issues (like 'nul' file)
- ✅ Color-coded output for better readability
- ✅ Comprehensive error handling

## Prerequisites

- Git installed on your system
- SSH key pair generated and added to your GitHub account
- GitHub repository created (for pushing)

## Installation

1. Copy `git-setup.sh` to your project directory or a location in your PATH
2. Make it executable:
```bash
chmod +x git-setup.sh
```

## Usage

### Basic Syntax

```bash
./git-setup.sh -u USERNAME -e EMAIL -r REPO [OPTIONS]
```

### Required Parameters

| Parameter | Description | Example |
|-----------|-------------|---------|
| `-u, --username` | GitHub username | `DmytroFedoryshyn` |
| `-e, --email` | Git email address | `dimonty2003@gmail.com` |
| `-r, --repo` | Repository (short or full URL) | `DmytroFedoryshyn/MyCapital` or `git@github.com:DmytroFedoryshyn/MyCapital.git` |

### Optional Parameters

| Parameter | Description | Default |
|-----------|-------------|---------|
| `-k, --ssh-key` | Path to SSH private key | `~/.ssh/id_rsa` |
| `-m, --message` | Initial commit message | `"Initial commit"` |
| `-b, --branch` | Branch name | `master` |
| `-i, --init` | Initialize new git repo | `false` |
| `-p, --push` | Push after commit | `false` |
| `-h, --help` | Display help message | - |

## Examples

### Example 1: Basic Setup (Current Directory)

Set up an existing project with your personal GitHub account:

```bash
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital
```

### Example 2: Setup with Custom SSH Key

Use a specific SSH key (for personal vs corporate accounts):

```bash
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital \
  -k ~/.ssh/id_rsa_personal
```

### Example 3: Initialize, Commit, and Push

Set up a new project from scratch and push immediately:

```bash
./git-setup.sh \
  -u JohnDoe \
  -e john@example.com \
  -r JohnDoe/NewProject \
  -i \
  -p \
  -m "Initial project setup"
```

### Example 4: Use Main Branch

Configure for repositories using 'main' instead of 'master':

```bash
./git-setup.sh \
  -u JaneDoe \
  -e jane@example.com \
  -r JaneDoe/ModernProject \
  -b main \
  -p
```

### Example 5: Corporate vs Personal Account

If you have a corporate account as default and want to use personal for specific repo:

```bash
# Corporate (default SSH key)
./git-setup.sh \
  -u CorporateUser \
  -e user@company.com \
  -r Company/CorporateRepo

# Personal (custom SSH key)
./git-setup.sh \
  -u PersonalUser \
  -e personal@gmail.com \
  -r PersonalUser/PersonalRepo \
  -k ~/.ssh/id_rsa_personal
```

## Common Use Cases

### Use Case 1: Clone Someone's Repo and Link to Your Fork

```bash
# Clone the original repo
git clone https://github.com/original/repo.git
cd repo

# Configure for your fork
./git-setup.sh \
  -u YourUsername \
  -e your@email.com \
  -r YourUsername/repo \
  -k ~/.ssh/id_rsa_personal
```

### Use Case 2: Convert Local Project to Git and Push

```bash
cd /path/to/your/project

./git-setup.sh \
  -u YourUsername \
  -e your@email.com \
  -r YourUsername/ProjectName \
  -i \
  -p \
  -m "Initial project commit"
```

### Use Case 3: Switch Repository Owner/Account

```bash
# Reconfigure existing repo to push to different account
./git-setup.sh \
  -u NewUsername \
  -e new@email.com \
  -r NewUsername/SameRepo \
  -k ~/.ssh/id_rsa_new_account
```

## Troubleshooting

### SSH Permission Denied

If you get `Permission denied (publickey)`:

1. **Check SSH key is added to GitHub:**
   ```bash
   ssh -T git@github.com
   ```

2. **Verify SSH key path:**
   ```bash
   ls -la ~/.ssh/
   ```

3. **Add your SSH key to GitHub:**
   - Copy public key: `cat ~/.ssh/id_rsa.pub`
   - Go to GitHub Settings → SSH and GPG keys → New SSH key
   - Paste and save

### Repository Doesn't Exist

The script will fail to push if the repository doesn't exist on GitHub. Create it first:

1. Go to https://github.com/new
2. Create repository (DON'T initialize with README, .gitignore, or license)
3. Run the script with `-p` flag

### Multiple SSH Keys (Corporate + Personal)

If you use multiple GitHub accounts:

1. **Generate separate SSH keys:**
   ```bash
   ssh-keygen -t rsa -b 4096 -C "personal@email.com" -f ~/.ssh/id_rsa_personal
   ssh-keygen -t rsa -b 4096 -C "work@company.com" -f ~/.ssh/id_rsa_work
   ```

2. **Add both keys to respective GitHub accounts**

3. **Use the script with appropriate key:**
   ```bash
   # For personal repos
   ./git-setup.sh -u PersonalUser -e personal@email.com -r PersonalUser/Repo -k ~/.ssh/id_rsa_personal
   
   # For work repos
   ./git-setup.sh -u WorkUser -e work@company.com -r Company/Repo -k ~/.ssh/id_rsa_work
   ```

## What the Script Does

1. ✅ Validates all required parameters
2. ✅ Checks if SSH key exists
3. ✅ Initializes git repository (if `-i` flag is used)
4. ✅ Configures repository-specific user name and email
5. ✅ Sets up SSH command to use specified key
6. ✅ Adds or updates remote origin
7. ✅ Removes problematic files (like 'nul' on Windows)
8. ✅ Stages and commits changes
9. ✅ Pushes to remote (if `-p` flag is used)

## Configuration Storage

All settings are stored in the repository's `.git/config` file:

```bash
# View your repository configuration
git config --list --local
```

## Notes

- Settings are **repository-specific** and won't affect global git config
- The script uses `set -e` to exit on any error
- Color-coded output helps identify issues quickly
- Safe to run multiple times on the same repository

## License

Free to use and modify as needed.

