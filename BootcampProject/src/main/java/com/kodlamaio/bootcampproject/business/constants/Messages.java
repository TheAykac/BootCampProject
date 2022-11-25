package com.kodlamaio.bootcampproject.business.constants;

public class Messages {

    public static class GlobalMessage {

        public static final String DataDeleted = "Data Deleted!";
        public static final String DataCreated = "Data Created!";
        public static final String DataUpdated = "Data Updated!";
        public static final String DataListed = "Data Listed!";
    }

    public static class Instructor {
        public static final String InstructorNationalIdentityNotFound = "Instructor National Identity Already Exists nationalIdentity: ";
        public static final String InstructorIdNotFound = "Instructor Id Not Exists id ";
    }

    public static class Applicant {
        public static final String ApplicantNationalIdentityNotFound = "Applicant National Identity Already Exists nationalIdentity: ";
        public static final String ApplicantIdNotFound = "Applicant Id Not Exists id ";
    }

    public static class Employee {
        public static final String EmployeeNationalIdentityNotFound = "Applicant National Identity Already Exists nationalIdentity: ";
        public static final String EmployeeIdNotFound = "Employee Id Not Exists id: ";


    }

    public static class BlackList {

        public static final String BlackListIdNotFound = "BlackList Id Not Exists id ";
        public static final String BlackListIdAlreadyExists = "Blacklist Id Already exists id: ";
    }

    public static class Application {
        public static final String ApplicationIdNotFoud = "Application Id Not Exists id: ";
        public static final String ApplicationStateNotFound = "Enter One of These Values : WAIT, APROVED, REJECT";
    }

    public static class BootCamp {
        public static final String BootcampIdNotFoud = "Bootcamp Id Not Exists id: ";
        public static final String FINISH_DATE_CANNOT_BEFORE_START_DATE = "End date cannot be earlier than start date";
    }


}
