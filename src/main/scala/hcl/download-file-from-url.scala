package hcl

import java.io.File
import sys.process._

// Execute below script to run the program. Do remember replace the parameter.
// sbt "run http://www.google.com/word.doc folder1 "word.doc" http://10.1.1.1:8080 simon.siah:awesome"

object DownloadFileFromUrl {

	def main(args: Array[String]) {
		val url = args(0)
		val folder = args(1)
		val filename = args(2)
		val proxy = args(3)
		val proxyuser = args(4)
		
		// Create folder if folder not exist.
		val dir1:File = new File("d:\\export")
		if ( !(dir1.exists))  {
			dir1.mkdir()
		}
		
		val dir2:File = new File("d:\\export\\" + folder)
		if ( !(dir2.exists))  {
			dir2.mkdir()
		}
		
		// Command line format 
		// "curl -x PROXY --proxy-user PROXY-USERNAME:PROXY-PASSWORD -u APP-USERNAME:APP-PASSWORD -L URL" #> new File("FILENAME") !!
		val cmd = "curl -x " + proxy + " --proxy-user " + proxyuser + " -u " + proxyuser + " -L " + url
		cmd #> new File("d:\\export\\" + folder + "\\" + filename ) !!
	}

}