// Place your Spring DSL code here
beans = {
	println "Resourse start..."
	
	httpClient(wslite.http.HTTPClient) {
		connectTimeout = 5000
		readTimeout = 10000
		useCaches = false
		followRedirects = false
		sslTrustAllCerts = true		
	}
	
	studentRestClient(wslite.rest.RESTClient) {
		url = "http://192.168.17.58:8090/grails-practice-examples"
		httpClient = ref('httpClient')		
	}
}
