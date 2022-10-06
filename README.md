# palvelinohjelmointi_Bookstore

## viikko2

Oli vähän säätämistä, kun piti asentaa Ubuntu 18:aan uudempi Eclipse, ja kun otin käyttöön myös tuon java17:n. -
Tämä git:in käyttökin on vähän uusi juttu, mutta on kyllä ollut jo aika kauan tarkoitus alkaa käyttää sitä, on se
sen verran hieno ja kätevä työkalu! - Mutta nyt näyttäisi homma alkavan toimia...

PS. Mielenkiintoista on, että kun otin käyttöön java17:n, niin silti java8:lla ohjelmoitu ja paketoitu
    varastosovellukseni toimii edelleen. - Olin varma, että se ei enää toimisi. - Mahtaakohan tämä johtua tuosta java:n
    ns. standalone-luonteesta, vai mistä... Kiva yllätys joka tapauksessa!

## viikko3

No-niin, nyt on lisätty kirjojen listaus ja alkoihan se h2-console:kin toimia, kun vain oli sama url kuin mitä siellä
applicationproperties-tiedostossakin... Kirjojen lisäys ja poisto, sekä kirjojen muokkaus on myös nyt toteutettu. -
Täytyy sanoa, että tuota kirjojen muokkausta oli kyllä varsin hauskaa miettiä ja testailla! (Otin käyttöön editId-muuttujan,
ettei tarvitse kirjoittaa samaa koodia moneen kertaan, eli DRY-pohjalta.) Tuo one-to-many on myös nyt lisätty.


## viikko4

Mielenkiintoisia nämä rest-jutut, ja json on kyllä olio-ohjelmoinnin yhteydessä mainio juttu myös, ja varsin käteviä
nämä orm-hommelit ovat, vaikka vähän sql:ää tuleekin ikävä. - Lisäsin Category-luokkaan 'booksInThisCategory'-muuttujan,
koska halusin, että Category:n yhteydessä näytetään, että montako kirjaa siihen kuuluu. (Kiitos vaan siitä FetchType.EAGER
vinkistä! :-#)# Ja nyt täytyy kyllä myöntää, että nuo 'getterit' ja 'setterit' ovat ihan hyvä keksintö myös!


## viikko5

Vielä vähän muutin RestController-luokan endpoint:teja rest-henkisemmiksi ja muutin Controller-luokan '/editbook'-endpoint:in
editointi-metodia siten, että ei poisteta olemassa olevaa kirjaa, vaan todellakin muutetaan sen sisältöä, ja siksi piti lisätä
Book-luokkaan metodi setId(), vaikka luulin, ettei sillä olisi mitään käyttöä, koska id tulee automaattisesti, mutta editoinnissapa
onkin, käyttöä siis!

## viikko6

Nyt on nuo validoinnit lisätty ja login / logout myös. Halusin oman login-tyylin, koska harjoitustyössä aion myös käyttää sellaista.
Keksin myös mielestäni aika nokkelan tavan validointi-palautteen ja kirjautuneen käyttäjän tervehtimiseen yhdistelemällä thymeleaf:ia,
javaScript:iä ja perinteistä java-olio-ohjelmointia. - Halusin, nimittäin, että käyttäjää tervehditään, ja että myös virheellisestä
syötteestä annetaan palautetta käyttäjälle, js-alert:illa. - Testasin myös virheen käsittelyä exceptionHandler-luokan avulla. Tämän
tein siten, että 'unohdin vahingossa' user-statuksella olevalle näkyviin kirjan muokkaus-vaihtoehdon, johon user:illa ei kuitenkaan
backend-puolella ole oikeuksia, ja sain myös näytettyä käyttäjälle js-alert-palautteen tähän liittyen, sen sijaan, että sovellus
olisi esim. kaatunut.
