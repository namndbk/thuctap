from bottle import run, get, post, request, delete, put

users = [{"User_Name" : "calipso", "User_Id" : "20162816"},
			{"User_Name" : "poseidon", "User_Id" : "12345678"},
			{"User_Name" : "hades", "User_Id" : "87654321"}]

@get("/user")
def getAllUser():
	return {"users" : users}

@get("/user/<User_Name>")
def getUser(User_Name):
	the_user = [user for user in users if user["User_Name"] == User_Name]
	return {"user" : the_user[0]}

@put("/user/<User_Name>")
def updateUser(User_Name):
	for user in users:
		if user["User_Name"] == User_Name:
			i = users.index(user)
			the_user = user
			break
	users.remove(the_user)
	users.insert(i,{"User_Name" : request.json.get("User_Name"), "User_Id" : request.json.get("User_Id")})
	return {"user" : users}

@post("/user")
def addUser():
	new_user = {"User_Name" : request.json.get("User_Name"), "User_Id" : request.json.get("User_Id")}
	users.append(new_user)
	return {"users" : users}

@delete("/user/<User_Name>")
def removeUser(User_Name):
	the_user = [user for user in users if user["User_Name"] == User_Name]
	users.remove(the_user[0])
	return {"user" : users}

run(reloader=True, debug=True)