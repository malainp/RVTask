# RVTask

GET https://rickandmortyapi.com/api/character/
```json
{
   "info":{
      "count":671,
      "pages":34,
      "next":"https://rickandmortyapi.com/api/character/?page=2",
      "prev":null
   },
   "results":[
      {
         "id":1,
         "name":"Rick Sanchez",
         "status":"Alive",
         "species":"Human",
         "type":"",
         "gender":"Male",
         "image":"https://rickandmortyapi.com/api/character/avatar/1.jpeg"
      }
   ]
}
```

GET https://rickandmortyapi.com/api/character/{character_id}
```json
{
   "id":78,
   "name":"Cowboy Rick",
   "status":"Alive",
   "species":"Human",
   "type":"",
   "gender":"Male",
   "image":"https://rickandmortyapi.com/api/character/avatar/78.jpeg",
}
```
