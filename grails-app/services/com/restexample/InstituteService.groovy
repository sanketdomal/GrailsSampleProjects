package com.restexample

import grails.transaction.Transactional
import wslite.rest.*
import grails.converters.JSON


class InstituteService {
	def studentRestClient

    def fetchStudentsFromApi() {
    	log.info("in fetchStudentsFromApi")
    	println "in fetchStudentsFromApi Service"
    	def restClient = studentRestClient
    	try{
    		println "in try"
    		def response = restClient.get(path: "/student/showStudents")                 
            

    		println " restClient.get done"
    		if( response == null ){
                
                throw new Exception("response is Null");
            }            
    		println response.dump()
    		println response.json
    		def jsonResponse = response.json 
    		return jsonResponse

    		} catch(Exception e){
    			throw new Exception ("Institute Service : Failed to get studetns")
    	}
    }

    def addNewStudentFromApi(def name,def email){
    	println "in addNewStudentFromApi Service"
    	def restClient = studentRestClient
    	try{
    		println "in try"
    		def response = restClient.post(path: "/student/addNewStudent")  
    		{					
                type "application/json"
                charset "UTF-8"
                json    "name" : name,
                        "email": email
            }                    

    		println " restClient.post done"
    		if( response == null ){
                
                throw new Exception("response is Null");
            }
            println response  
    		//println response.dump()
    		return response

    		} catch(Exception e){
    			throw new Exception ("Institute Service : Failed to add student")
    	}
    }

    def updateStudentFromApi(def nameToBeUpdated, def name,def email){
    	println "in updateStudentFromApi Service"
    	def restClient = studentRestClient
    	try{
    		println "in try"
    		def response = restClient.put(path: "/student/updateStudent")  
    		{					
                type "application/json"
                charset "UTF-8"
                json    "name" : name,
                        "email": email,
                        "nameToBeUpdated": nameToBeUpdated
            }                    

    		println " restClient.put done"
    		if( response == null ){
                
                throw new Exception("response is Null");
            }
            println response  
    		//println response.dump()
    		return response

    		} catch(Exception e){
    			throw new Exception ("Institute Service : Failed to update student")
    	}
    }

    def deleteStudentFromApi(def email)	{
    	println "in deleteStudentFromApi Service"
    	def restClient = studentRestClient
    	try{
    		println "in try"
    		def response = restClient.put(path: "/student/deleteStudent")  
    		{					
                type "application/json"
                charset "UTF-8"
                json    "email": email
            }                    

    		println " restClient.put done"
    		if( response == null ){
                
                throw new Exception("response is Null");
            }
            println response  
    		//println response.dump()
    		return response

    		} catch(Exception e){
    			throw new Exception ("Institute Service : Failed to delete a student record")
    	}
    }

}
