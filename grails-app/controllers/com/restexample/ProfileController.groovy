package com.restexample

import grails.converters.JSON

class ProfileController {
	def instituteService
    def fetchStudentInfoViaAjax() {
    	log.info(" in fetchStudentInfoViaAjax ")
    	println "in fetchStudentInfoViaAjax"
    	try{
    			def studentList = instituteService.fetchStudentsFromApi()
    			render studentList as JSON

    	}catch(Exception e){
    			throw new Exception("Profile Controller : Failed to fetch Student Information")
    	}
    }

    def addNewStudentViaAjax(){
    	println "addNewStudentViaAjax"
    	try{
			def name = "TestName"
			def email = "myemail@gmail.com"

			def addNewStudent = instituteService.addNewStudentFromApi(name,email)	
			if(addNewStudent == false) {
				render "failed to add"
			}
			render "success"
		} catch(Exception e){
			throw new Exception ("Controller Exception : Failed to add Student")		
		}
    }

    def updateStudentViaAjax(){
    	println "updateStudentViaAjax"
    	try{
    		def nameToBeUpdated = "sanket"
			def newName = "TestName123"
			def newEmail = "sanketdomal@gmail.com"

			def updateStudent = instituteService.updateStudentFromApi(nameToBeUpdated,newName,newEmail)	
			if(updateStudent == false) {
				render "failed to update"
			}
			render "success"
		} catch(Exception e){
			throw new Exception ("Controller Exception : Failed to update Student")		
		}
    }

    def deleteStudentViaAjax(){
    	println "deleteStudentViaAjax"
    	try{    		
			def email = "sanket@yahoo.com"

			def isDeleted = instituteService.deleteStudentFromApi(email)	
			if(isDeleted == false) {
				render "failed to delete"
			}else{
				render "successfully deleted"	
			}			
		} catch(Exception e){
			throw new Exception ("Controller Exception : Failed to delete Student record")		
		}
    }
}
