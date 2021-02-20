# UserLocationApi
This Api allows to create usernames and post codes list

POST API

Accepts a list of Names and Postcodes in the HTTP request body 
URL : http://localhost:8080/users/addUserPostCodeList
Sample Request body

[ {
    "name":"John",
    "postcode":"6000" 
},
{
    "name":"Asyley",
    "postcode":"6010" 
},
{
    "name":"Smith",
    "postcode":"6021" 
}
]

GET API

Receives postcode range and returns in the response body the list of names belonging to that postcode range,
sorted alphabetically as well as the total number of characters of all names combined. 

URL: http://localhost:8080/users/getNamesBetween/6000/6021
