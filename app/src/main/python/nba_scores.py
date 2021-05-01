import urllib.request

def SportDemo(day, month, year):
    # Set url parameter
    if int(month) < 10:
        month = "0" + month
    url = f"http://api.isportsapi.com/sport/basketball/schedule/basic?api_key=hfdvdfspz8YRtFiX&date={year}-{month}-{day}&&leagueID=111"

    # Call iSport Api to get data in json format
    f = urllib.request.urlopen(url)
    content = f.read()

    #print(content.decode('utf-8'))
    games = content.decode('utf-8')
    games = games.split("}")
    games_list = []
    for game in games:
        if game.count('leagueName":"NBA"') > 0:
            games_list.append(game)
            #print(game)

    teams = []
    ct =0
    for game in games_list:
        if ct !=0:
            temp = game.split(",")
            hometeam = temp[7]
            hometeam = hometeam.replace('"homeName":', "")
            hometeam = hometeam.replace("'","")
            hometeam = hometeam.replace('"',"")
            match =()
            match+=(hometeam,)
            awayteam = temp[8]
            awayteam = awayteam.replace('"awayName":', "")
            awayteam = awayteam.replace("'", "")
            awayteam = awayteam.replace('"', "")
            match+= (awayteam,)
            teams.append(match)
        else:
            temp = game.split(",")
            hometeam = temp[8]
            hometeam = hometeam.replace('"homeName":', "")
            hometeam = hometeam.replace("'", "")
            hometeam = hometeam.replace('"', "")
            match = ()
            match += (hometeam,)
            awayteam = temp[9]
            awayteam = awayteam.replace('"awayName":', "")
            awayteam = awayteam.replace("'", "")
            awayteam = awayteam.replace('"', "")
            match += (awayteam,)
            teams.append(match)


        ct+=1
    #teams.pop(0)
    return teams


