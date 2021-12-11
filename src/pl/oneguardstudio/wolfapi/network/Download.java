package pl.oneguardstudio.wolfapi.network;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

class Download {
	
	static void DownloadFile(String Url, String LocalFileName) {
		try (BufferedInputStream in = new BufferedInputStream(new URL(Url).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(LocalFileName)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
				}
	}
	
	/*void downloadFile(String Url, String LocalFileName) throws IOException {
	    File localFile = new File(LocalFileName);
	    if (localFile.exists()) {
	        localFile.delete();
	    }
	    localFile.createNewFile();
	    URL url = new URL(Url);
	    OutputStream out = new BufferedOutputStream(new FileOutputStream(LocalFileName));
	    InputStream in = url.openConnection().getInputStream();
	    byte[] buffer = new byte[1024];

	    int numRead;
	    while ((numRead = in.read(buffer)) != -1) {
	        out.write(buffer, 0, numRead);
	    }
	    if (in != null) {
	        in.close();
	    }
	    if (out != null) {
	        out.close();
	    }
	}*/
	
}
