# Git Commands

"Git is software for tracking changes in any set of files, usually used for coordinating work among programmers collaboratively developing source code during software development. Its goals include speed, data integrity, and support for distributed, non-linear workflows (thousands of parallel branches running on different systems). <br>
Git was created by Linus Torvalds in 2005 for development of the Linux kernel." - *in Wikipédia*. <br>

## 1 - Directories and files management: <br>

### 1.1 - Add

```bash
$ mkdir directoryName                                           # To create a folder

$ echo "This is a first line of file" > text.txt                # To create and write in a text file 
$ echo "Another line" > text.txt                                # Substitution of first line
$ echo "More line" >> text.txt                                  # Append a line after "Another line\n"

$ touch aSimpleFile.fileExtension                               # To create a file with a certain extension in current directory
```

### 1.2 - Remove

```bash
$ rmdir directoryName || rm directoryName                       # To remove an empty folder
$ rm -r directoryName                                           # To remove a non-empty folder

$ rm fileName                                                   # To remove a file
```

### 1.3 - Rename and Move
       
```bash
$ mv oldName.extension newName.extension                        # To rename a file, to be done in a file's directory
$ mv oldDirectory/ newDirectory/                                # To rename a folder
$ mv fileName.extension ../newDirectory                         # To move a file to another folder in ../pwd directory

$ cd folderName/                                                # Entry in a selected folder
$ cd ..                                                         # Go back to previous folder
```

### 1.4 - View

```bash
$ tree.com //a                                                  # To view complete directory tree
$ pwd                                                           # To view a current directory path
$ ls                                                            # To view all files in current folder
$ ls -la                                                        # To view all files in current folder, including all hidden files
```   

## 2 - Git

### 2.1 - Initialize

```bash
$ git init                                                      # To create a local repository
$ git clone remoteRepositoryLink                                # To download a remote repository, using GitHub
```

### 2.2 - Commits

```bash
$ git add fileName.extension                                    # To add a certain file
$ git add . || git add --all || git add -a                      # To add all modified files and folders

$ git commit -m "Explain your changes"                          # To associate latest changes to a message
$ git commit -m "Explain your changes" --date "X days ago"      # To add a commit X days before the current day
$ git -a -m "Message" || git -am "Message"                      # Add + Commit

$ git log                                                       # View all changes
$ git log -X                                                    # View previous X changes
$ git log -X --oneline                                          # View previous X changes, summarized
$ git log -X --patch || git log -X -p                           # View modifications, using diff mode

$ git status                                                    # To see a list with all files tracked and untracked
$ git status -s || git status --short                           # To see a summarized list with deleted and modified files
$ git commit --amend                                            # To change last commit message using VIM for default
```

### 2.3 - Merge

```bash
$ git merge testing                                             # To merge two or more branch modifications, to do in main branch
$ git commit                                                    # If is conflict, implement this command before solve it
```
 
### 2.4 - Branch

```bash
$ git branch                                                    # To view all of created branches

$ git branch newBranchName                                      # To create a new branch
$ git checkout newBranchName                                    # To modify the console to the new branch path
$ git checkout -b newBranchName                                 # Create and modify to new brach

$ git branch -d branchName                                      # To delete a certain branch locally
$ git push origin --delete branchName                           # To delete a certain branch remotely
```   

### 2.5 - Remote

```bash
$ git clone remoteRepositoryLink                                # To download a remote repository, using GitHub
$ git push origin branch_name                                   # To upload modifications at branch_name in remote repository
$ git fetch                                                     # To download latest modifications in remote repository
$ git pull                                                      # To download latest modifications in remote repository and merge
$ git remote add origin git@github.com:remoteRepositoryLink     # Using a GitHub repository as reference
$ git checkout --track origin/newBranch                         # To create a new branch which can be viewed in remote or local
$ git remote -v                                                 # To view all add remote repository             
```

### 2.6 - Reverting

```bash
$ git checkout -- fileName                                      # To revert changes in a single file (not in stage)
$ git checkout --hard                                           # To reset non-saved modifications in all files (not in stage)
$ git reset HEAD fileName                                       # To revert a single file with add and without commit
$ git reset                                                     # To revert all changes with add and without commit
$ git reset --hard commitID                                     # To revert changes with commit and without push
$ git revert commitID                                            # To revert changes with commit and push. Bad practise.
```

### 2.7 - [Gitignore](https://git-scm.com/docs/gitignore)

```bash
folderName/                                                       # Don't commit this folder
fileName.extension                                                # Don't commit this file
!name/**/*.txt                                                    # Don't ignore any .txt files inside directory name
```


<br>

### Credits: <br>
[Git](https://web.fe.up.pt/~arestivo/presentation/git/#1), by André Restivo <br>
[Oh-My-Zsh Git](https://kapeli.com/cheat_sheets/Oh-My-Zsh_Git.docset/Contents/Resources/Documents/index) <br>

**@ Fábio Araújo de Sá** <br/>
**2021/2022**