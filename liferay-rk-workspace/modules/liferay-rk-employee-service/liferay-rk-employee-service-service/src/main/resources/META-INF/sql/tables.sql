create table Employee_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	phoneNumber LONG,
	salary LONG,
	emailAddress VARCHAR(75) null,
	joiningDate DATE null,
	leavingDate DATE null
);