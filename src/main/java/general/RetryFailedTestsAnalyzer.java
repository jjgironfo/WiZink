package general;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTestsAnalyzer implements IRetryAnalyzer {

	private int count;
	private static final int MAX_TRY = 1;
	
	public RetryFailedTestsAnalyzer() {
		super();
	}

	/*
	 * (non-Javadoc) Method to retry failed test the specified number of times
	 * 
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 */
	@Override
	public boolean retry(ITestResult iTestResult) {
		boolean retryFailed = false;
		// Check if test not succeed
		if (!iTestResult.isSuccess()) {
			// Check if maxtry count is reached
			if (count < MAX_TRY) {
				// Increase the maxTry count by 1
				count++;
				// Mark test as failed
				iTestResult.setStatus(ITestResult.FAILURE);
				// Tells TestNG to re-run the test
				retryFailed = true;
			} else {
				// If maxCount reached,test marked as failed
				iTestResult.setStatus(ITestResult.FAILURE);
			}
		} else {
			// If test passes, TestNG marks it as passed
			iTestResult.setStatus(ITestResult.SUCCESS);
		}
		return retryFailed;
	}

}
