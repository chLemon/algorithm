Set objShell = CreateObject("WScript.Shell")
objShell.CurrentDirectory = CreateObject("Scripting.FileSystemObject").GetParentFolderName(WScript.ScriptFullName)
objShell.Run "cmd /c python app.py", 1, False
WScript.Sleep 3000
objShell.Run "http://127.0.0.1:8081"
