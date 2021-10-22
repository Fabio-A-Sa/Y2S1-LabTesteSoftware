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
$ git add fileName.extension                                    # To add 
$ git add . || git add --all || git add -a                      #

$ git commit -m "Explain your changes"                          # To associate changes and topics
$ git commit -m "Explain your changes" --date "X days ago"      # To add a commit X days before the current day
$ git -a -m "Message" || git -am "Message"                        # To

$ git log 
$ git log -X
$ git log -X --oneline
```

### 2.3 - Merge

```bash
       
```

### 2.4 - Branch

```bash
       
```   

### 2.5 - Remote

```bash
       
```   



<br>

### Credits: <br>
[Git](https://web.fe.up.pt/~arestivo/presentation/git/#1), by André Restivo <br>
[Oh-My-Zsh Git](https://kapeli.com/cheat_sheets/Oh-My-Zsh_Git.docset/Contents/Resources/Documents/index) <br>

**@ Fábio Araújo de Sá** <br/>
**2021/2022**