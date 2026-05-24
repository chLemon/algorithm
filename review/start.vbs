Set objShell = CreateObject("WScript.Shell")
objShell.CurrentDirectory = CreateObject("Scripting.FileSystemObject").GetParentFolderName(WScript.ScriptFullName)
objShell.Run "pythonw app.py", 0, False
WScript.Sleep 2000
objShell.Run "http://127.0.0.1:5000"
