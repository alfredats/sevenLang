14:     PrintWriter filePrint = null;
18:       filePrint = new PrintWriter(fileOut);
26:           filePrint.println(lineCount + ": " + line);
37:       if (filePrint != null) {
38:         filePrint.close();
