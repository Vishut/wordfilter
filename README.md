# wordfilter

1- Rest controller (/filter) to filter bad words from comment
-> Url : /wordfilter/filter
-> RequestType : POST
-> Sample Request :
{
	"comment":"you.r are n0t a good piss"
}

Sample Response:
{
    "text": "you.r are n0t a good piss",
    "badwords": [
        "piss"
    ],
    "status": "OK",
    "offensive": true
}

2- Badwords loaded from badwords.txt
3- LeetSpeak loaded from leetspeak.txt