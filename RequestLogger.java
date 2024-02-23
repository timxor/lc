class RequestLogger {

	// initailization of requests hash map
	private HashMap<String, Integer> requests;
	int limit;

	public RequestLogger(int timeLimit) {
		requests = new HashMap<String, Integer> ();
		limit = timeLimit;
	}

	// function to accept and deny message requests

	public boolean messageRequestDecision(int timestamp, String request) {
		// checking whether the specific request exists in
		// the hash map or not
		if (!this.requests.containsKey(request)) {
			this.requests.put(request, timestamp);
			return true;
		}
		// if it exists, check whether its time duration
		// lies within the defined timestamp
		if (timestamp - this.requests.get(request) >= limit) {
			// store this new request in the hash map, and return true
			this.requests.put(request, timestamp);
			return true;
		} else {
			// the request already exists within the timestamp
			// and is identical, request should
			// be rejected, return false
			return false;
		}
	}

	public static void main(String[] args) {
		// Driver code
		int[] times = { 1, 5, 6, 7, 15 };
		String[] messages = {
			"good morning",
			"hello world",
			"good morning",
			"good morning",
			"hello world"
		};
		// here we will set the time limit to 7
		RequestLogger obj = new RequestLogger(7);
		for (int i = 0; i<messages.length; i++) {
			System.out.print(i + 1);
			System.out.println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
			System.out.println("\tMessage request decision: " + obj.messageRequestDecision(times[i], messages[i]));
			System.out.println(PrintHyphens.repeat("-", 100));
		}
	}
}
