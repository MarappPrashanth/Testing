asa
[[]\[]]
			case "DELETE_FILES":

				File folder3 = new File(RunClass.DownloadFilePath);
				File[] listOfFiles3 =folder3.listFiles();

				for (int i = 0; i < listOfFiles3.length; i++) {
					if (listOfFiles3[i].isFile()) {

						listOfFiles3[i].delete();
					} else {

						evntMsg = "No Files to delete";

					}

					evntMsg = listOfFiles3[i] + " deleted successfuly";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
					StepLevelReport.create_RowData();
				}
				break;

			case "_LABELNOTEXIST":

				val = getValue(uiElement);
				report.info("Captured label is:  " + val);
				if (val.contains(objMap.get("CHECK_POINT"))) {
					evntMsg = "The specific label: " + objMap.get("CHECK_POINT")
							+ " is displayed in the page which is NOT expected";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
					StepLevelReport.create_RowData();
				} else {
					evntMsg = "The specific label: " + objMap.get("CHECK_POINT")
							+ " is NOT displayed in the page as expected";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
					StepLevelReport.create_RowData();
				}
				break;

			case "VERIFY_DOWNLOADS":

				String loc2 = null;
				File folder2 = new File(RunClass.DownloadFilePath);
				File[] listOfFiles2 = folder2.listFiles();

				for (int i = 0; i < listOfFiles2.length; i++) {
					if (listOfFiles2[i].isFile()) {

						System.out.println(loc2 = listOfFiles2[i].toString());

						if (loc2.contains(objMap.get("CHECK_POINT"))) {

							evntMsg = objMap.get("CHECK_POINT") + " is downloaded successfuly";
							report.info(evntMsg);
							Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
							StepLevelReport.create_RowData();
						} else {

							evntMsg = objMap.get("CHECK_POINT") + "  NOT Validated successfuly";
							report.info(evntMsg);
							Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
							StepLevelReport.create_RowData();
						}
					}
				}
				break;

			case "OPTIONAL_CLICK":

				if (uiElement == null) {
					evntMsg = "Element not exist as expected, skipped the step." + objMap.get("OBJECT_NAME");
					break;
				} else {
					uiElement.click();
					evntMsg = "Clicked on " + objMap.get("OBJECT_NAME");

					break;
				}

				/*
				 * case "IMAGEEXISTS":
				 * 
				 * Screen sc = new Screen(); if
				 * (sc.exists(Constants.sikuliImagePath + objMap.get("DATA")) !=
				 * null) {
				 * 
				 * evntMsg = "Element validated successfuly";
				 * report.info(evntMsg);
				 * Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass",
				 * evntMsg); StepLevelReport.create_RowData();
				 * 
				 * } else {
				 * 
				 * evntMsg = "Element NOT able to locate"; report.info(evntMsg);
				 * Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail",
				 * evntMsg); StepLevelReport.create_RowData(); } break;
				 * 
				 * case "IMAGENOTEXISTS":
				 * 
				 * Screen sc1 = new Screen(); if
				 * (sc1.exists(Constants.sikuliImagePath + objMap.get("DATA"))
				 * != null) {
				 * 
				 * evntMsg = "Element validated which is NOT AS EXPECTED";
				 * report.info(evntMsg);
				 * Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail",
				 * evntMsg); StepLevelReport.create_RowData();
				 * 
				 * } else {
				 * 
				 * evntMsg =
				 * "Element not present on the screen which IS AS EXPECTED";
				 * report.info(evntMsg);
				 * Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass",
				 * evntMsg); StepLevelReport.create_RowData(); } break;
				 */

			


			case "CSV_DATAEXIST":

				String downloadFilepath = RunClass.DownloadFilePath;
				Map<String, Object> preferences = new Hashtable<String, Object>();
				preferences.put("profile.default_content_settings.popups", 0);
				preferences.put("download.prompt_for_download", "false");
				preferences.put("download.default_directory", downloadFilepath);

				String loc1 = null;
				String data1 = "";
				File folder1 = new File(RunClass.DownloadFilePath);
				File[] listOfFiles1 = folder1.listFiles();

				for (int i = 0; i < listOfFiles1.length; i++) {
					if (listOfFiles1[i].isFile()) {

						System.out.println(loc1 = listOfFiles1[i].toString());

					} else if (listOfFiles1[i].isDirectory()) {
						System.out.println(

								"Directory " + listOfFiles1[i].getName());
					}
				}

				File file = new File(loc1);

				Scanner inputStream = new Scanner(file);

				while (inputStream.hasNext()) {

					data1 = data1 + " " + inputStream.nextLine().toString().replace("\"", "").replace(",", " ");

				}

				System.out.println(data1);

				if (data1.contains(objMap.get("CHECK_POINT"))) {
					evntMsg = "Data validated successfully in the CSV";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
					StepLevelReport.create_RowData();

				} else {
					evntMsg = "Data not found in the CSV";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
					StepLevelReport.create_RowData();
				}
				break;

			case "CSV_DATANOTEXIST":

				String downloadFilepath_csv = RunClass.DownloadFilePath;
				Map<String, Object> preferences_csv = new Hashtable<String, Object>();
				preferences_csv.put("profile.default_content_settings.popups", 0);
				preferences_csv.put("download.prompt_for_download", "false");
				preferences_csv.put("download.default_directory", downloadFilepath_csv);

				String loc_csv = null;
				String data_csv = "";
				File folder_csv = new File(RunClass.DownloadFilePath);
				File[] listOfFiles_csv = folder_csv.listFiles();

				for (int i = 0; i < listOfFiles_csv.length; i++) {
					if (listOfFiles_csv[i].isFile()) {

						System.out.println(loc_csv = listOfFiles_csv[i].toString());

					} else if (listOfFiles_csv[i].isDirectory()) {
						System.out.println("Directory " + listOfFiles_csv[i].getName());
					}
				}

				File file_csv = new File(loc_csv);

				Scanner inputStream_csv = new Scanner(file_csv);

				while (inputStream_csv.hasNext()) {

					data_csv = data_csv + " " + inputStream_csv.next().toString().replace("\"", "").replace(",", " ");

				}

				System.out.println(data_csv);

				if (data_csv.contains(objMap.get("CHECK_POINT"))) {
					evntMsg = objMap.get("CHECK_POINT") + " found in the CSV which is not as expected";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
					StepLevelReport.create_RowData();

				} else {
					evntMsg = objMap.get("CHECK_POINT") + " NOT found in the CSV which is as expected";
					report.info(evntMsg);
					Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
					StepLevelReport.create_RowData();
				}
				break;

			case "OPEN_NEWTAB":

				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));

				evntMsg = "New TAB opened";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
				break;

			case "CLOSE_BROWSERWINDOW":
				driver.close();
				evntMsg = "Closed the browser";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
				break;

			case "ClOSE_DRIVER_OPENFIREFOX":

				driver.quit();
				WebDriver driver1 = new FirefoxDriver();
				driver1.get(objMap.get("DATA"));
				break;

			case "ClOSE_DRIVER_OPENCHROME":

				driver.quit();

				driver = new ChromeDriver();
				driver.get(objMap.get("DATA"));
				break;

			case "DOUBLE_CLICK":
				doubleClick(uiElement);
				evntMsg = "Double clikced on element: " + objMap.get("OBJECT_NAME");
				// report.info("Double clikced on element:
				// "+objMap.get("OBJECT_NAME"));
				// report.info(evntMsg);
				break;

			

			

			case "COMPAREDATA":
				uiElement1 = getObject(objMap.get("OBJECT_NAME_1"));
				compareData(uiElement, uiElement1);
				evntMsg = "Values are compared successfully";
				// report.info(evntMsg);
				break;

			case "SA_SELECTCHECKBUTTON":
				SA_selectCheckButton(uiElement);
				break;

			case "WAIT_FOR_PAGELOADING":
				// waitForLoadingIcon();
				evntMsg = "Waiting for loading icon";
				// report.info(evntMsg);
				break;

			case "WAIT_FOR_ELEMENT":
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objMap.get("OBJECT_ATRB1"))));
				break;

			case "SELECTCHECKBOX":
				selectCheckBox(uiElement, objMap.get("OBJECT_NAME"));
				break;

			case "UNCHECKCHECKBOX":
				uncheckCheckBox(uiElement, objMap.get("OBJECT_NAME"));
				break;

			default:
				if (action.contains("VALIDATE")) {

					validate(action, uiElement, objMap);

				}
				if (action.contains("RUNUTIL")) {

					// data=getDynamicData(data);
					try {
						runUtil(action, objMap.get("DATA"));
						evntMsg = "Upload operation is successfull";
						Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
						StepLevelReport.create_RowData();
						Thread.sleep(5000);
					} catch (Exception e) {
						evntMsg = "Upload operation is NOT successfull";
						Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
						StepLevelReport.create_RowData();
					}
				}

			}

			report.info("-----------------------------------------------------");

			// This block of logic is to store the previous values when the data
			// being entered in the application
			if (action.equals("DELETE_MAIL_DOMAIN") ||action.equals("ENTER") || action.equals("SELECT") || action.equals("FETCH_VALUE")) {

				if (!mainTCData.get("TEMPLATE_REF").toUpperCase().contains("Y")) {
					// DriverTest.prevValues.add(data);
					DriverTest.prevDataMap = new HashMap<String, String>();
					DriverTest.prevDataMap.put("RowIndex", Integer.toString(DriverTest.dataIndex));
					DriverTest.prevDataMap.put("FiledName", "N/A");
					DriverTest.prevDataMap.put("Data", data);
					DriverTest.prevDataList.add(DriverTest.prevDataMap);
					// DriverTest.prevDataMap.clear();
					///////////////////////////// STORE DATA
					///////////////////////////// LOGIC/////////////////////////////////////////////
					// Auto:getAppData#34
					DriverTest.storeDataMap = new HashMap<String, String>();
					DriverTest.storeDataMap.put("RowIndex", Integer.toString(DriverTest.dataIndex));
					DriverTest.storeDataMap.put("FiledName", "N/A");
					DriverTest.storeDataMap.put("Data", storedata);
					DriverTest.storeDataList.add(DriverTest.storeDataMap);

				}

			}

			// ====================================================================================================

			// evntMsg="Info:"+action+ " action on object:
			// "+objMap.get("OBJECT_NAME")+" is successfull"+" >>> "+evntMsg;
			if (!(action.contains("VALIDATE"))) {
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
				report.info(evntMsg);
				waitFor(objMap.get("SYNC_REF"));
			}
			// report.info(evntMsg);

		} catch (StaleElementReferenceException e) {

			excpMsg = "Unable to perform " + action + " action on object: " + objMap.get("OBJECT_NAME")
					+ ". The respetive object is not attached to the page document " + e.getStackTrace();
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", excpMsg);
			StepLevelReport.create_RowData();
			report.info(excpMsg);
		} catch (NoSuchElementException e) {
			excpMsg = "Unable to perform " + action + " action on object: " + objMap.get("OBJECT_NAME")
					+ ". The respetive object was not found in DOM " + e.getStackTrace();
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", excpMsg);
			StepLevelReport.create_RowData();
			report.info(excpMsg);
		} catch (Exception e) {
			excpMsg = "Unable to perform " + action + " action on object: " + objMap.get("OBJECT_NAME")
					+ "make object prperties are supplied properly or verify any application changes occurred";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", excpMsg);
			report.info(excpMsg);
			StepLevelReport.create_RowData();

		}

	}

	/*
	 * This function create object based on the object details passed
	 * Parameter1: Property Name Parameter1: Property
	 */
	@SuppressWarnings("unchecked")
	public WebElement getObject(String objSource) throws Exception {
		HashMap<String, String> tempRec;
		String strID, strProperty;
		String objMapFilePath = Constants.objectMapsFilePath;
		List<HashMap<String, String>> objMapsRec = new ArrayList<HashMap<String, String>>();

		if (!(objSource.contains("BLANK"))) {
			Object[] tempArr1 = objSource.split(":");
			String objRef = (String) tempArr1[0];
			String objName = (String) tempArr1[1];
			objMapsRec = Excel.getDataSetOnContext(objMapFilePath, objRef, "OBJECT_NAME", objName);
			// objMapsRec=Excel.getDataSetOnContext(objMapFilePath,
			// objMap.get("SCREEN_REF"),"OBJECT_NAME",objMap.get("OBJECT_NAME"));

			// report.info("Object being used: "+objSource);
			Object[] tmpArr2 = objMapsRec.toArray();
			tempRec = (HashMap<String, String>) tmpArr2[0];
			strID = tempRec.get("PROPERTY_NAME");
			strProperty = tempRec.get("PROPERTY_VALUE");

			try {

				switch (strID.toUpperCase()) {

				case "ID":
					uiElement = driver.findElement(By.id(strProperty));
					break;

				case "NAME":
					uiElement = driver.findElement(By.name(strProperty));
					break;

				case "CLASSNAME":
					uiElement = driver.findElement(By.className(strProperty.trim()));
					break;

				case "LINKTEXT":
					uiElement = driver.findElement(By.linkText(strProperty));
					break;

				case "XPATH":
					uiElement = driver.findElement(By.xpath(strProperty));
					;
					break;

				case "CSS":
					uiElement = driver.findElement(By.cssSelector(strProperty));
					break;
				}
				if (uiElement.isDisplayed()) {
					objFlag = true;
				} else
					objFlag = false;
			} catch (Exception e) {
				uiElement = null;
				objFlag = false;
			}
		} else {
			// do nothing
		}
		return uiElement;

	}

	//////////////////////////////////////////////////////

	// ==========End of te function================'

	// This function is defined to compare the value from the two different
	// objects
	public static void compareData(WebElement elmt1, WebElement elmt2) {
		String a, b;
		a = getValue(elmt1);
		b = getValue(elmt2);

		if (a.equals(b)) {
			report.info("Values are displayed as per the requirement");

		} else {
			report.info("Values are not displayed as per the requirement");
		}
	}

	private void runUtil(String action, String data) throws IOException {
		//
		String tempData[], exeName, strUtil;
		tempData = action.split(":");
		exeName = tempData[1];
		strUtil = Constants.exeFilePath + exeName + " " + RunClass.UploadFilePath + data;
		Runtime.getRuntime().exec(strUtil);
		System.out.println("File Uploaded");
	}

	// This function is defined to compare the value from the two different
	// objects
	public static void compareValue(String s1, String s2) {
		String evntMsg = null;
		if (s1.contains(s2)) {
			report.info("Data: " + s1 + " displayed as per the requirement");
			evntMsg = "Data: " + s1 + " displayed as per the requirement";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();

		} else {
			report.info("Data: " + s1 + " not displayed as per the requirement");
			evntMsg = "Data: " + s1 + " not displayed as per the requirement";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}
	}

	public static String getValue(WebElement elmt) {
		String val = null;
		/*
		 * try { val=elmt.getAttribute("value"); } catch(NullPointerException
		 * e1){
		 * 
		 * try { val=elmt.getText(); } catch (NullPointerException e2){
		 * 
		 * String
		 * evntMsg="NullPointerException..while capturing the data from application"
		 * ; report.info(evntMsg);
		 * 
		 * return val; } }
		 * 
		 * return val;
		 */
		try {

			val = elmt.getAttribute("value");
			if (val == null || val.isEmpty() || val.startsWith("0", 0)) {
				val = elmt.getText();
			}

		} catch (NullPointerException e) {
			excpMsg = "NullPointerException..while capturing the data from application";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Exception", excpMsg);
			StepLevelReport.create_RowData();
			report.info(evntMsg);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			evntMsg = "Error occurred while capturing data from the application";
			report.info(evntMsg);
		}
		return val;

	}

	public static String checkMail(WebElement elmt,String DataValue) {
		String val = null;
	
		try {

			val = elmt.getAttribute("value");
			if (val == null || val.isEmpty()) {
				val = elmt.getText();
				String merge = val;
				if(merge.contains(DataValue)){
				String[] differentMails = merge.split("\n");
				String[] array2 = Arrays.stream(differentMails).map(String::trim).toArray(String[]::new);
				
				String part1 = DataValue;
						int k=0;
				        for(int i=0;i<array2.length;i++){
                      
				            if(array2[i].equalsIgnoreCase(part1)){
				                k=i;
				                break;
				            }
				        }

				   try{
					   int index=k+1;
					  String cssprop="[class='list list_emails editable'] >div:nth-child("+index+") [class='icon-clear icon-clear_email-list clickable']";
					   driver.findElement(By.cssSelector(cssprop)).click();
					   evntMsg = "Removed : "+DataValue;
						report.info(evntMsg);
				   }
				   catch(Exception e)
				   {
					   evntMsg = "Not Found";
						report.info(evntMsg);
				   }
				   
			}
				else
					 evntMsg = "Domain name is not exist";
					report.info(evntMsg);
			}
		} catch (NullPointerException e) {
			excpMsg = "NullPointerException..while capturing the data from application";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Exception", excpMsg);
			StepLevelReport.create_RowData();
			report.info(evntMsg);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			evntMsg = "Error occurred while capturing data from the application";
			report.info(evntMsg);
		}
		return val;

	}
	public static String getPlaceHolder(WebElement elmt) {
		String var;
		var = elmt.getAttribute("placeholder");
		return var;
	}

	public static String getLinkValue(WebElement elmt) {
		String var;
		var = elmt.getAttribute("href");
		return var;
	}

	public static void verifyObjectStatus(WebElement uiElement, HashMap<String, String> objMap) {
		String status = null;
		if (uiElement.isEnabled()) {
			status = "enabled";

		} else {
			status = "disabled";
		}

		if (status.contains(objMap.get("CHECK_POINT"))) {

			evntMsg = "Object: " + objMap.get("OBJECT_NAME") + " is " + objMap.get("CHECK_POINT") + " as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();

		} else {
			evntMsg = "Object: " + objMap.get("OBJECT_NAME") + " is NOT " + objMap.get("CHECK_POINT") + " as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}
	}

	// Developed by : Pramod
	// Revision History: YYYY
	// Functionality: Method to verify if the checkbox is clicked or
	// not(Implemented on 5/30/2016)

	public void selectCheckBox(WebElement elmt, String objName) {
		String evntMsg;

		if (!uiElement.isSelected()) {
			elmt.click();
			evntMsg = "Clicked on checkbox: " + objName;
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
			// report.info(evntMsg);
		} else {
			evntMsg = "Check box:" + objName + " is already selected";
			// report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
		}

	}

	public void uncheckCheckBox(WebElement elmt, String objName) {
		String evntMsg;

		if (uiElement.isSelected()) {
			elmt.click();
			evntMsg = "Clicked on checkbox: " + objName;
			// report.info(evntMsg);
		} else {
			evntMsg = "Check box:" + objName + " is already deselected";
			// report.info(evntMsg);
		}

	}

	// .................................................
	public void SA_selectCheckButton(WebElement elmt) {

		try {
			String bg = elmt.getCssValue("background-color");
			// report.info(bg);
			String target = "rgba(52, 51, 51, 1)";
			if (!bg.equals(target)) {
				elmt.click();
				evntMsg = "Checkbutton selected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
			} else {
				evntMsg = "Checkbutton already selected";
				// report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();

			}
		} catch (Exception e) {
			evntMsg = "Error occured while selecting Checkbutton";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}
	}

	// ..............................................................

	// Method to retrieve the current DATE and TIME
	public String getDynamicData(String data) {
		String funName, temp, data1 = null;

		// temp=objMap.get("DATA");
		String Object[] = data.split("Auto:");
		funName = Object[1];

		if (funName.contains("getPrevData")) {
			temp = "getPrevData";
		} else if (funName.contains("CurrentDate")) {
			temp = "CurrentDate";
		}

		///////////////////////////// STORE DATA
		///////////////////////////// LOGIC/////////////////////////////////////////////
		else if (funName.contains("getAppData")) {
			temp = "getAppData";
		} else {
			temp = Object[1];
		}

		switch (temp) {

		case "CurrentDate":
			data1 = getCurrentDate(funName);
			break;

		case "getPrevData":
			data1 = getPrevData(funName);
			break;
		///////////////////////////// STORE DATA
		///////////////////////////// LOGIC/////////////////////////////////////////////
		case "getAppData":
			data1 = getAppData(funName);
			break;

		}
		return data1;

	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */
	public String getDynamicTime(String data) {
		String funName, temp = null;
		String data2 = null;
		// temp=objMap.get("DATA");
		String Object[] = data.split("Auto:");
		funName = Object[1];

		if (funName.contains("getFutureTime")) {
			temp = "getFutureTime";
		}

		else {
			temp = Object[1];
		}

		switch (temp) {

		case "getFutureTime":
			data2 = getFutureTime(funName);
			break;

		}
		return data2;
	}

	public static String getFutureTime(String strData) {
		String strTemp[], strTemp1[], strUnit, strVal;
		String str = null;
		String str1 = null;
		int tmVal = 0;
		Calendar newTime;

		Calendar now = Calendar.getInstance();

		if (strData.contains("#")) {
			strTemp = strData.split("#");
			strTemp1 = strTemp[1].split(":");
			strUnit = strTemp1[0];
			strVal = strTemp1[1];
			int b = Integer.parseInt(strVal);
			report.info("Add value:" + b);
			// String str = Integer.toString(tmVal);

			switch (strUnit.toUpperCase()) {

			case "MIN":
				newTime = Calendar.getInstance();
				newTime.add(Calendar.MINUTE, Integer.parseInt(strVal));
				tmVal = newTime.get(Calendar.MINUTE);
				report.info("future Minutes : " + tmVal);

				break;

			case "HOUR":
				newTime = Calendar.getInstance();
				newTime.add(Calendar.HOUR_OF_DAY, Integer.parseInt(strVal));
				tmVal = newTime.get(Calendar.HOUR_OF_DAY);
				report.info("future Hours : " + tmVal);
				break;

			}
			// str = Integer.toString(tmVal);
			str1 = String.format("%02d", tmVal);
			report.info("future Time : " + str1);
		}
		return str1;

	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */

	private static String getPrevData(String fnName) { // [OLd]

		// TODO Auto-generated method stub
		String temp1, temp2, temp3, fieldName, rowIndex, sData = null;

		if (fnName.contains("<")) { // When the format is as ex
									// "{UserId:GetPrevData:#5[Participient]}"

			String Object1[] = fnName.split("#");

			temp1 = Object1[1];
			String Object2[] = temp1.split("<");
			rowIndex = Object2[0];
			String Object3[] = Object2[1].split(">");
			fieldName = Object3[0];

			// HashMap<String,String>
			// prevData[]=DriverTest.prevDataList.toArray();
			ArrayList<HashMap<String, String>> prevData = DriverTest.prevDataList;

			for (int i = 0; i < prevData.size(); i++) {
				if (prevData.get(i).get("RowIndex").contains(rowIndex)
						&& prevData.get(i).get("FiledName").contains(fieldName)) {

					sData = prevData.get(i).get("Data");
					break;
				}
			}
		}
		// When the format is as ex "{UserId:GetPrevData:#5"
		else {
			String Object11[] = fnName.split("#");
			rowIndex = Object11[1];
			ArrayList<HashMap<String, String>> prevData1 = DriverTest.prevDataList;

			for (int j = 0; j < prevData1.size(); j++) {
				if (prevData1.get(j).get("RowIndex").contains(rowIndex)) {

					sData = prevData1.get(j).get("Data");
					break;
				}

			}

		}

		return sData;

	}

	///////////////////////////// STORE DATA
	///////////////////////////// LOGIC/////////////////////////////////////////////
	private static String getAppData(String fnName) { // [OLd]

		// TODO Auto-generated method stub
		String temp1, temp2, temp3, fieldName, rowIndex, sData = null;

		if (fnName.contains("<")) { // When the format is as ex
									// "{UserId:GetPrevData:#5[Participient]}"

			String Object1[] = fnName.split("#");

			temp1 = Object1[1];
			String Object2[] = temp1.split("<");
			rowIndex = Object2[0];
			String Object3[] = Object2[1].split(">");
			fieldName = Object3[0];

			// HashMap<String,String>
			// prevData[]=DriverTest.prevDataList.toArray();
			ArrayList<HashMap<String, String>> storeData = DriverTest.storeDataList;

			for (int i = 0; i < storeData.size(); i++) {
				if (storeData.get(i).get("RowIndex").contains(rowIndex)
						&& storeData.get(i).get("FieldName").contains(fieldName)) {

					sData = storeData.get(i).get("Data");
					break;
				}
			}
		}
		// When the format is as ex "{UserId:GetPrevData:#5"
		else {

			String Object11[] = fnName.split("#");
			rowIndex = Object11[1];

			// HashMap<String,String>
			// prevData[]=DriverTest.prevDataList.toArray();
			ArrayList<HashMap<String, String>> storeData1 = DriverTest.storeDataList;

			for (int j = 0; j < storeData1.size(); j++) {
				if (storeData1.get(j).get("RowIndex").contains(rowIndex)) {

					sData = storeData1.get(j).get("Data");
					if (sData.contains("has been processed. As a reminder, please restart the device.")) {
						String replaceString = sData.replace("Journey ", "");
						String replaceString1 = replaceString
								.replace(" has been processed. As a reminder, please restart the device.", "");// replaces
																												// all
																												// occurrences
																												// of
																												// is
																												// to
																												// was
						System.out.println(replaceString1);
						sData = replaceString1;
					}

					break;
				}

			}

		}

		return sData;

	}

	// This function is defined to get system data with format
	public String getCurrentDate(String fnName) {
		String name;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		datetime = datetime.replaceAll("[^a-zA-Z0-9]", "");

		String Object1[] = fnName.split("#");

		name = Object1[1];
		return datetime + name;
	}

	public static void SA_getdate() throws ParseException {
		String val, val1, val2 = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm z");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		val1 = dateFormat.format(cal.getTime());
		System.out.println(val2 + " - My System Time Time");
		Date d = dateFormat.parse(val1);
		cal.setTime(d);
		cal.add(Calendar.MINUTE, -1);
		val2 = dateFormat.format(cal.getTime());
		System.out.println(val2 + " - My System Time plus One Minute");
		val = uiElement.getText();
		System.out.println(val + " - My Application Time");

		if (val.contains(val1) || val.contains(val2)) {
			evntMsg = "Date is displayed as per Requirement";
			// report.info(evntMsg);
		} else {
			evntMsg = "Date is NOT displayed as per Requirement";
			// report.info(evntMsg);
		}

	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++

	public static void SA_getTime() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		String val, val1, val2, val3 = null;
		val1 = dateFormat.format(cal.getTime());
		evntMsg = val1 + " - System Time";
		report.info(evntMsg);
		val = uiElement.getText();
		evntMsg = val + " - Application Time";
		report.info(evntMsg);
		cal.add(Calendar.MINUTE, -1);
		val2 = dateFormat.format(cal.getTime());
		cal.add(Calendar.MINUTE, -1);
		val3 = dateFormat.format(cal.getTime());

		if (val.contains(val1) || val.contains(val2) || val.contains(val3)) {
			evntMsg = "Time is displayed as per Requirement";
			// report.info(evntMsg);
		} else {
			evntMsg = "Time is NOT displayed as per Requirement";
			// report.info(evntMsg);
		}
	}

	///////////////////////////////////////////////////////////////
	public void assignedColorSrc(WebElement elmt1) {
		String source;
		source = elmt1.getAttribute("src");

		if (source != null)

			report.info(source);

		else
			report.info("failed to fetch color");
	}

	// New....
	// long appWait; //******************************************************
	public void waitFor(String wtRef) throws Exception { // New....
		// long appWait;
		String elementFlag;
		WebElement wtElement;
		int cnt = 1;
		if (!wtRef.equals("BLANK") && wtRef.contains(":")) {
			wtElement = getObject(wtRef);
			if (!objFlag) {
				report.info("----Waiting for page synchronization-----");
				elementFlag = "NotFound";
				while (cnt <= 3 && elementFlag.equals("NotFound")) {

					wtElement = getObject(wtRef);
					if (objFlag && wtElement.isDisplayed()) {
						cnt = 100;
						elementFlag = "Found";
					} else {
						Thread.sleep(5000);
						cnt = cnt + 1;
						elementFlag = "NotFound";
					}

				}

				if (cnt > 3 && elementFlag.equals("NotFound")) {
					// e.printStackTrace();
					report.info("------Expected object" + wtRef + "is not found timed out cut-off time-------");
				}

			}

		}

		else
			waitWithTime(wtRef);

	}

	// Wait using Driver wait method
	@SuppressWarnings("null") // Old running
	public void waitWithTime(String wtTime) throws InterruptedException {
		long appWait;

		if (!wtTime.equals("BLANK") && (!wtTime.contains(":"))) {
			// report.info("-----"+wtTime);
			String temp = wtTime.trim();
			appWait = (long) Float.parseFloat(temp);

			// driver.manage().timeouts().implicitlyWait(appWait,
			// TimeUnit.SECONDS);
			Thread.sleep(appWait);
			// report.info("------------------------Entered wait block and
			// waiting for: "+wtTime+" miliseconds------------------------");

		}

	}

	// Wait using sleep method
	@SuppressWarnings("null")
	public void sleep(String wtTime) throws InterruptedException {
		long appWait;

		if (!wtTime.equals("BLANK")) {
			// report.info("-----"+wtTime);
			String temp = wtTime.trim();
			appWait = (long) Float.parseFloat(temp);
			Thread.sleep(appWait);
		}
	}

	// ====================================================
	public static void validate(String action, WebElement uiElement, HashMap<String, String> objMap) throws Exception {
		String control, val = null;
		String Object1[] = action.split("VALIDATE");
		control = Object1[1];

		switch (control.toUpperCase()) {

		case "_LABEL":
			val = getValue(uiElement);
			report.info("Captured label is:  " + val);
			verify(uiElement, control, val, objMap);
			break;

		case "_GETCOORDINATES":

			Point source = uiElement.getLocation();
			int xcord = source.getX();
			String xcordString = String.valueOf(xcord);
			int ycord = source.getY();
			String ycordString = String.valueOf(ycord);
			// System.out.println("X and Y coordinates are "+ xcordString + ","
			// + ycordString);
			String loc = objMap.get("CHECK_POINT");
			String splitloc[] = null;
			splitloc = loc.split(":");

			if (xcordString.equals(splitloc[0]) && ycordString.equals(splitloc[1])) {
				evntMsg = "Element Co-Ordinates are: " + xcordString + "," + ycordString + " as expected";
				report.info(evntMsg);
				// report.info("Element Co-Ordinates are: "+ splitloc[0] + "," +
				// splitloc[1]);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
				// System.out.println("ELEMENT LOCATED");
			} else {
				evntMsg = "Element Co-Ordinates are: " + xcordString + "," + ycordString + " NOT as expected";
				report.info(evntMsg);
				// report.info("Element Co-Ordinates are: "+ splitloc[0] + "," +
				// splitloc[1]);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();
			}
			break;

		case "_WIDTH":

			int source1 = uiElement.getSize().getWidth();
			int xcord1 = source1;
			String xcordString1 = String.valueOf(xcord1);

			System.out.println("Size of the Element is " + xcordString1 + " PIXELS");
			String loc1 = objMap.get("CHECK_POINT");
			if (xcordString1.contains(loc1)) {
				evntMsg = "WIDTH DISPLAYED AS EXPECTED";
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();

			} else {
				evntMsg = "WIDTH NOT DISPLAYED AS EXPECTED";
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();

			}
			break;

		case "_TEXT":
			val = uiElement.getText();
			System.out.println(val);
			report.info("Captured label is:  " + val);
			verify(uiElement, control, val, objMap);
			break;

		case "_TITLE":
			val = getTitle(uiElement);
			break;

		case "_PLACEHOLDER":
			val = getPlaceHolder(uiElement);
			verify(uiElement, control, val, objMap);
			break;

		case "_OBJECT":
			// val=getValue(uiElement);
			verify(uiElement, control, val, objMap);
			break;

		case "_TOOLTIP":
			verifyTooltip(uiElement, objMap);
			break;

		case "_ICON_STATUS": // [NEW]
			String class_name = uiElement.getAttribute("class");

			if (class_name.contains("unchkEnable") || class_name.contains("icon-arrow-left")) {
				val = "unchecked";
			} else if (class_name.contains("chkEnable") || class_name.contains("icon-arrow-right")) {
				val = "checked";
			}
			verify(uiElement, control, val, objMap);
			break;
		case "_FIELD_STATUS": // [NEW]  Added New case Vikas
			String class_name3 = null;
			class_name3 = uiElement.getAttribute("class");
			// report.info(class_name1);
			if (class_name3.contains("required")) {
				val = "required";
			} else {
				val = "Not required";
			}
			report.info(val);
			verify(uiElement, control, val, objMap);
			break;

		case "_ARROW_STATUS":
			String class_name1 = uiElement.getAttribute("class");

			if (class_name1.contains("icon-arrow-left")) {
				val = "INBOUND";
			} else if (class_name1.contains("icon-arrow-right")) {
				val = "OUTBOUND";
			}
			verify(uiElement, control, val, objMap);
			break;

		case "_OPTION_STATUS": // [NEW]
			String class_name2 = null;
			class_name2 = uiElement.getAttribute("class");
			// report.info(class_name1);
			if (class_name2.contains("disabled")) {
				val = "disabled";
			} else {
				val = "enabled";
			}
			report.info(val);
			verify(uiElement, control, val, objMap);
			break;

		case "_OBJECTNOTEXIST":
			// val=getValue(uiElement);
			if (!objFlag) {
				evntMsg = "The specific object: " + objMap.get("OBJECT_NAME") + "is NOT displayed as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
			} else {
				evntMsg = "The specific object: " + objMap.get("OBJECT_NAME") + "is displayed which is NOT as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();

			}
			break;

		case "_OBJECTNOTVISIBLE":
			// val=getValue(uiElement);
			if (uiElement.isDisplayed()) {
				evntMsg = "The specific object: " + objMap.get("OBJECT_NAME") + " is visible which is NOT expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();
			} else {
				evntMsg = "The specific object: " + objMap.get("OBJECT_NAME") + " is NOT visible which is as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();

			}
			break;

		/*
		 * case "_LIST_ALL_ITEMS": // [NEW] case "_LIST_ITEM": // [NEW]
		 * val=getListItems(uiElement); verify(uiElement,control,val,objMap);
		 * break;
		 */

		case "_LIST_ALL_ITEMS": // [NEW]
			val = getListItems(uiElement);
			verify(uiElement, control, val, objMap);
			break;

		case "_LIST_ITEM": // [NEW]

			validateListItem(objMap);
			break;

		case "_SELECTED_LIST_ITEM": // [NEW as on June 13, 2016]
			Select select = new Select(uiElement);
			WebElement option = select.getFirstSelectedOption();
			val = option.getText();
			System.out.println(val);
			verify(uiElement, control, val, objMap);
			break;

		case "_OBJECTSTATUS": // [NEW] SOURABH
			// val=getValue(uiElement);
			verifyObjectStatus(uiElement, objMap);
			break;

		case "_LIST_ORDER:ASCEND":
			validateItemsOrder(uiElement, "ASCEND"); // [NEW]
			break;

		case "_LIST_ORDER:DESCEND":
			validateItemsOrder(uiElement, "DESCEND"); // [NEW]
			break;

		case "_URL":
			verifyURL(driver, objMap);
			break;

		case "_CURRENT_URL":
			verifyCurrentUrl(driver, objMap);
			break;

		case "_STATUS": // [NEW]
			// Boolean b=uiElement.isSelected();
			Boolean b = uiElement.isSelected()
					|| uiElement.getCssValue("background-color").equals("rgba(52, 51, 51, 1)");
			System.out.println(b);
			
							if (b) {
								if(b.toString().equalsIgnoreCase("TRUE"))
								{
									val="TRUE";
								}
								
							} else if(b.toString().equalsIgnoreCase("FALSE")) {
								val = "FALSE";
							}
							verify(uiElement, control, val, objMap);
							break;// need to add logic 

		

		default:
			if (control.contains("STYLE")) {

				validateStyle(control, uiElement, objMap);

			}

		}

	}

	// Function to get URL details displaed in navigated window

	public static void verifyURL(WebDriver driver, HashMap<String, String> objMap) { // July
																						// 7/28/2016

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String url = driver.getCurrentUrl();
		report.info("Captured URL is:" + url);
		if (url.equals(objMap.get("CHECK_POINT"))) {
			evntMsg = "URL: " + objMap.get("CHECK_POINT") + " is displayed as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
		} else {
			evntMsg = "URL: " + objMap.get("CHECK_POINT") + " is NOT displayed";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	// Function to get URL details displaed in navigated window
	public static void verifyCurrentUrl(WebDriver driver, HashMap<String, String> objMap) {
		String evntMsg;
		String url = driver.getCurrentUrl();
		report.info("Captured URL is:" + url);
		if (url.equals(objMap.get("CHECK_POINT"))) {
			evntMsg = "URL: " + objMap.get("CHECK_POINT") + " is displayed as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
		} else {
			evntMsg = "URL: " + objMap.get("CHECK_POINT") + " is NOT displayed as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}
	}

	public static String getTitle(WebElement elmt) {
		String var;
		var = elmt.getAttribute("title");
		return var;
	}

	public static void verifyTooltip(WebElement uiElement, HashMap<String, String> objMap) {
		// TODO Auto-generated method stub
		String Tooltip = uiElement.getAttribute("data-tooltip");
		report.info(Tooltip);
		if (Tooltip.equals(objMap.get("CHECK_POINT"))) {
			evntMsg = "Tooltip: " + objMap.get("CHECK_POINT") + " is displayed as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
		} else {
			evntMsg = "Tooltip: " + objMap.get("CHECK_POINT") + " is NOT displayed";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
		}

	}

	public static void validateListItem(HashMap<String, String> objMap) { // Jul
																			// 28,
																			// 2016
		String listItem;
		listItem = objMap.get("CHECK_POINT");
		if (listItem.contains("~")) {
			listItem = listItem.replace("~", "");
			if (verifyListItem(listItem)) {

				evntMsg = "List item - " + listItem + " is displayed in the list " + objMap.get("OBJECT_NAME")
						+ " which is NOT as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();

			} else {

				evntMsg = "List item - " + listItem + " is NOT displayed in the list " + objMap.get("OBJECT_NAME")
						+ " as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
			}

		} else {

			if (verifyListItem(listItem)) {
				evntMsg = "List item - " + listItem + " is displayed in the list " + objMap.get("OBJECT_NAME")
						+ " as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();

			} else {

				evntMsg = "List item - " + listItem + " is NOT displayed in the list " + objMap.get("OBJECT_NAME")
						+ " which is NOT as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();
			}
		}

	}

	// Verify list item availability in the list
	public static boolean verifyListItem(String listItem) { // Jul 28, 2016
		String listItems;
		boolean itemFound;

		listItems = getListItems(uiElement);
		if (listItems.contains(listItem)) {
			itemFound = true;

		}

		else {
			itemFound = false;

		}
		return itemFound;

	}

	// Function to get list items from the dropdown

	public static String getListItems(WebElement uiElement) { // [NEW]

		String temp, sItems = null;

		try {

			Select select = new Select(uiElement);
			ArrayList<WebElement> allOptions = (ArrayList<WebElement>) select.getOptions();
			// report.info("Value:"+allOptions);
			sItems = allOptions.get(0).getText() + ",";
			if (sItems.contains("None")) {
				sItems = allOptions.get(1).getText() + ",";
			}
			for (int i = 1; i < allOptions.size(); i++) { // Note: need to
															// verify for other
															// projects, for
															// senseware
															// considered
															// validation from
															// item 1 onwards,
															// please chnag it
															// accordingly
				sItems = sItems + allOptions.get(i).getText();
				if (i < (allOptions.size() - 1)) {
					sItems = sItems + ",";
				}
			}
			report.info("List items: " + sItems);

		} catch (NullPointerException e) {
			evntMsg = "NullPointerException exception occurred while capturing listitems from the list";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
			sItems = null;
		}

		return sItems;

	}

	/// This function is used to validate list items in the dropdown list

	public static void validateItemsOrder(WebElement uiElement, String orderType) { // [NEW]

		evntMsg = null;
		if (verifyItemsOrder(uiElement, orderType)) {

			evntMsg = "List items are displayed in " + orderType + "ING order as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();

		} else {

			evntMsg = "List items are NOT displayed in " + orderType + "ING order as expected";
			report.info(evntMsg);
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();

		}

	}

	// This function is used to verify the list items order [NEW]

	public static Boolean verifyItemsOrder(WebElement uiElement, String orderType) { // [NEW]

		String items = getListItems(uiElement);
		String[] strItems = items.split(",");
		String previous = ""; // empty string
		String current;
		Boolean B;
System.out.println(uiElement);
WebElement Checkstatus=uiElement;
if(Checkstatus.toString().contains("triggerType"))
{
	List<String> list = new ArrayList<String>(Arrays.asList(strItems));
	list.remove(0);
	previous = list.get(0) + ",";
	//for (Integer i = 1; i < strItems.length-1; i++) {
		for(int i=1;i<list.size();i++){
		current = list.get(i);

		switch (orderType) {
		case "ASCEND":
			if (current.compareTo(previous) < 0) {
				return false;

			}
			break;

		case "DESCEND":

			if (current.compareTo(previous) > 0) {
				return false;
			}
			break;

		}

		previous = current;

	}
}
else
{
	previous = strItems[0] + ",";
	for (Integer i = 1; i < strItems.length; i++) {
		current = strItems[i];

		switch (orderType) {
		case "ASCEND":
			if (current.compareTo(previous) < 0) {
				return false;

			}
			break;

		case "DESCEND":

			if (current.compareTo(previous) > 0) {
				return false;
			}
			break;

		}

		previous = current;

	}
}

	return true;

	}

	///////////////////////////////////////////////////////////////////////////////////////

	// Then compare which type of validation is required
	public static void verify(WebElement uiElement, String control, String data, HashMap<String, String> objMap) {
		if (control.contains("OBJECT")) { // [NEW]

			if (uiElement.isDisplayed()) {
				evntMsg = objMap.get("OBJECT_NAME") + " is displayed as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();
				// report.info("-----------------------------------------------------");

			}

			else {

				evntMsg = objMap.get("OBJECT_NAME") + " is NOT displayed";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();
				// report.info("-----------------------------------------------------");
			}

		}

		else {

			String expResult;
			if (objMap.get("CHECK_POINT").contains("getPrevData")) {

				expResult = objMap.get("CHECK_POINT");
				expResult = getPrevData(expResult);
				report.info(expResult);
			}

			else if (objMap.get("CHECK_POINT").contains("getAppData")) {

				expResult = objMap.get("CHECK_POINT");
				expResult = getAppData(expResult);
				report.info(expResult);
			}

			else {

				expResult = objMap.get("CHECK_POINT");

			}

			if (data.trim().contains(expResult)) {
				// Log Successfull

				evntMsg = objMap.get("CHECK_POINT") + " is displayed as expected";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
				StepLevelReport.create_RowData();

				report.info("-----------------------------------------------------");

			}

			else {

				evntMsg = objMap.get("CHECK_POINT") + " is NOT displayed";
				report.info(evntMsg);
				Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
				StepLevelReport.create_RowData();
				report.info("-----------------------------------------------------");
			}

		}

	}

	// ==Function End===

	public static void validateStyle(String control, WebElement uiElement, HashMap<String, String> objMap) {
		// TODO Auto-generated method stub
		String style, val = null;
		String Object1[] = control.split(":");
		style = Object1[1];

		switch (style.toUpperCase()) {

		case "BACKGROUND":
			val = uiElement.getCssValue("background-color");
			report.info(val);
			evntMsg = "BACKGROUND color" + objMap.get("CHECK_POINT");
			break;

		case "BORDER":
			val = uiElement.getCssValue("border");
			report.info(val);
			evntMsg = "Border color" + objMap.get("CHECK_POINT");
			break;

		case "COLOR":
			val = uiElement.getCssValue("color");
			System.out.println(val);
			evntMsg = "text forground color:" + objMap.get("CHECK_POINT");
			break;

		case "STYLE":
			val = uiElement.getAttribute("style");
			evntMsg = "Style:" + objMap.get("CHECK_POINT");
			break;

		case "OPACITY":
			val = uiElement.getCssValue("opacity");
			evntMsg = "Opacity:" + objMap.get("CHECK_POINT");
			break;

		case "UNDERLINE":
			val = uiElement.getCssValue("border-bottom");
			System.out.println(val);
			evntMsg = "Opacity:" + objMap.get("CHECK_POINT");

			break;

		}

		evntMsg = style.toUpperCase() + ": " + objMap.get("CHECK_POINT");
		// Then compare which type of validation is required

		if (val.contains(objMap.get("CHECK_POINT"))) {

			evntMsg = evntMsg + " displayed as expected";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Pass", evntMsg);
			StepLevelReport.create_RowData();
			report.info(evntMsg);
			report.info("-----------------------------------------------------");

		}

		else {
			evntMsg = evntMsg + " NOT displayed as expected";
			Common.updateStepExecutionInfo(Common.getTimeStamp(), "Fail", evntMsg);
			StepLevelReport.create_RowData();
			report.info(evntMsg);
			report.info("-----------------------------------------------------");
		}

	}

	// ==================================================================================
	// Function to double click on UI element
	// =================================================================================
	public void doubleClick(WebElement element) {
		try {
			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();
			report.info("Double clicked the element");
		} catch (StaleElementReferenceException e) {
			report.info("Element is NOT attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			report.info("Element " + element + " is NOT found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			report.info("Element " + element + " is NOT clickable " + e.getStackTrace());
		}
	}

	// ==Function End===
	public void waitForLoadingIcon() {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-icon")));

	}

	/////////////////////
	public static boolean chkalphabetical_order(LinkedList<String> product_names) {

		String previous = ""; // empty string

		for (final String current : product_names) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}

		return true;

	}
	///////////////////////////

}

=======
//asd
>>>>>>> 0dad3579e9724a1603a96e38900498c66b6c25a7
