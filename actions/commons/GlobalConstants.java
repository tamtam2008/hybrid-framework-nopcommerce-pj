package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH+ File.separator+ "downloadFiles";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;

	
	
	public static void main(String[] args) {
		System.out.println(PROJECT_PATH);
		System.out.println(UPLOAD_FILE_FOLDER);
		System.out.println(DOWNLOAD_FILE_FOLDER);
	}

}
