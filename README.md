# Ryhmatöö
Midagi ESTERi-sarnast, aga isiklikule raamatukogule

autorid: Carmen Akkermann ja Marie Tempel

2.rühmatöö

projekti põhjalik kirjeldus, kus on kirjas programmi eesmärk ja selgitus programmi üldisest tööst, vajadusel lühike kasutusjuhis;
iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid;
projekti tegemise protsessi kirjeldus (erinevad etapid ja rühmaliikmete osalemine neis);
iga rühmaliikme panus (sh tehtud klassid/meetodid) ja ajakulu (orienteeruvalt);
tegemise mured (nt millistest teadmistest/oskustest tundsite projekti tegemisel puudust);
hinnang oma töö lõpptulemusele (millega saite hästi hakkama ja mis vajab arendamist);
selgitus ja/või näited, kuidas programmi osi eraldi ja programmi tervikuna testisite ehk kuidas veendusite, et programm töötab korrektselt.

Me jätkasime oma eelmise rühmatöö projektiga. Sooviks oli luua isiklikule "raamatukogule" andmebaas otsinguvõimalustega. Meil on klassid Raamat, TolkeRaamat, Raamaturiiul, Riiul, Peaklass, AndmeteHoidla ja MustRuut. Kuna me jätkasime sama projektiga, siis eeldan, et eelmine kord tehtud klasse ja meetodeid ei pea uuesti kommenteerima (allpool on ka esimese rühmatöö README). Programm tuleb käima panna gradle'i abil.

Lisasime juurde 2 klassi MustRuut ja AndmeteHoidla. MustRuut on graafiline kasutajaliides ja AndmeteHoidla on 1.rühmatöö järel saadud soovitus. AndmeteHoidlasse tõstsime ümber meetodid loeRiiulidFailist ja riiuliIsenditeLoomineJaListiLisamine klassist Raamaturiiul ja meetodid loeRaamatudFailist ja isenditeLoomineJaListiLisamine klassist Raamat.

Enne koodi kirjutamise juurde asumist panime kirja ka plaani, mida on vaja teha, mis järjekorras ja milline peaks olema lõpptulemus (esimese rühmatöö puhul oli see osa natuke kaootilisem). Alustasime teist rühmatööd sellega, et Marie lõi AndmeteHoidla klassi ja tekitas graafilise liidese põhja, luues kujunduse (seal hulgas ka vaatas, et akna suuruse muutmisel kujundus väga käest ära ei läheks). Carmen jätkas graafilise liidese ja esimeses rühmatöös tehtud programmi kokkuviimisega. Selle käigus sai natuke muudetud Peaklassi, tekitades Peaklassi juurde meetodi ettevalmistus, mis loeb vajalikud andmed failidest ning tekitab AndmeteHoidlasse soovitud listid (raamatutest ja riiulitest), et vajalikud andmed ka MustRuut klassis kättesaadavad oleksid. Klassi MustRuut sai lisatud meetod väljumiseKontroll, mis küsib kasutajalt, kas ta tõesti tahab programmi sulgeda. Edasi tegi Marie päringute süsteemi selliseks, et see toimiks ka graafilise liidesega. Peaklassi sai selle käigus lisatud meetod kõikVastavadPealkirjad, mis otsib üles kindlale pealkirjale vastavad kõik raamatud (sealhulgas, kui otsitakse originaal pealkirjaga, siis kuvab kõik lisaks ka kõik tõlked). Meetod infoRaamatuteJärgi sai tehtod suurelt ümber. Nüüd vaatab see meetod, et kui vasakpoolses tulbas klikitakse raamatu peale, siis kuvab antud raamatu täiskirje. Kõik üle jäänud meetodid peaks tegema sama, mis 1.rühmatöös (ainult, et nüüd tagastavad ainult pealkirjad). Samal ajal Carmen tegeles logifaili salvestamise meetodiga, mis kirjtuab inimesele loetavalt tekstifaili kõik tehtud toimingud, ja lõi kasutusjuhendi, mis avaneb peaLava "kohal" eraldi aknana ning kus on juhised programmi kasutamiseks.

Kuigi Carmen tegi ilmselt raskema osa programmeerimisest, siis ma ütleks, et meie panus oli suhteliselt võrdne, sest info vahetus oli pidev ning kui üks tabas probleemi, siis teine kohe aitas. (Carmen arvab, et kuna tegelikult tegime mõlemad mahuliselt umbes sama palju tööd ja ülesanded õnnestus täpselt nii ära jagada, et see teema, mis ühel oli segane, oli teisel selgem, siis tegelikult oli tööjaotus päris hea ja võrdse raskusastmega :)) Ajaliselt on keeruline öelda, palju täpselt kulus. Ilmselt umbes 9 h mõlemal, aga töösse süvenenult ei pane kella tähele ning seega ei ole kindel, kas see ka tõele vastab.

Põhiliseks mureks oli erinevates arvutites programmi tööle saamisega. Kui ühel jooksis ilusasti, siis teiel andis pea alati esimese asjana veateadet ning saigi jälle tund veedetud omavahel vesteldes, et mida üks või teine tegi ja kuidas programm tööle saada. Kindlasti tekitas probleeme ka gradle. Kuidas seda põhi programmiga siduda või kuidas see üldse korralikult tööle saada. Gradle'i parem tundmine ja mõistmine oleks kindlasti kasuks tulnud. Lisaks tekkis aeg-ajalt mõlemal koodi kirjutades sisulisi probleeme, millega teineteist jooksvalt aitasime.

Programmitöö korrektsuses veendusime iga muudatuse järel programmi käivitades ja vaadates, mis juhtub. Näiteks akna suuruse muutmise juures sai korduvalt programmi käivitatud ning vaadatud, mis juhtub, kuhu hüpavad näiteks erinevad nupud. Lisatud/muudetud funktsionaalsusi testis nii funktsionaalsuse looja kui paariline.

........................................................................................................................................
1.rühmatöö

Programmi üldine eesmärk on aidata orienteeruda koduses raamatukogus, näiteks kui inimene omab ligi tuhat raamatut, siis tuleks kasuks, kui saaks otsida mingi programmi abil, kas kindel raamat on inimesel juba olemas või kus see asub.

Meil on klass Raamat, kus on kirjas kõik raamatu andmed. Meetodid loeRaamatudFailist ja isenditeLoomineJaListiLisamine loevad failist raamatud.txt andemed raamatute kohta ning tekitavad vastavad objektid ning lisavad listi List<Raamat> kõigiRaamatuteList. 
Eraldi on tehtud alamklass TolkeRaamat, kus on siis lisaks üldisele kirjas ka tõlkja, originaal pealkiri ja muu ainult tõlke raamatule omapärane. Samuti on veel klassid Raamaturiiul ja Riiul. Tõlkeraamatus ei ole eraldi olulisi meetoteid, tõlkeraamat luuakse klassi Raamat meetodis isenditeLoomineJaListiLisamine.
Klassis Raamaturiiul on kindla riiuli tunnusjooned nagu kui suur riiul on ja mis eristab seda teistest. Sarnaselt klassile Raamat on ka elles klassis meetodid loeRiiulidFailist ja riiuliIsenditeLoomineJaListiLisamine, mis loevad ette antud failis riiulid.txt andmed ning muudavad need Raamaturiiulite listiks.
Klassis Riiul on eraldi märge täpse asukoha kohta ja viide Raamaturiiulile, kus asub antud raamat (märge asukohale on maatriksi kordinaatidena). Ka klassis Riiul puuduvad tähtsamad meetodid. Riiul on nüüd täpsemalt see, mis käib Raamatu kirjesse.
Olemas on ka Peaklass, kus on järgmised meetodid:
  1) lugemiseTsitaat(), mis väljastab randomiga ühe tsitaadi raamatute kohta enne muu programmi töö algust;
  2) kasutajaTegevused(String sisend), mis valib vastavalt peameetodis saadud sisendile, millist tegevuse meetodit rakendada;
  3) infoPealkirjaJärgi(), mis väljastab kogu info selle raamatu kohta, mille pealkirja kasutaja sisestas;
  4) üheAutoriKõikRaamatud(), mis väljastab kogu info selle raamatu kohta, mille autori perenime kasutaja sisestas;
  5) üheRiiuliKõikRaamatud(), mis väljastab kogu info nende raamatute kohta, mis asuvad kasutaja sisestatud tunnusega riiulil;
  6) üheKeeleKõikRaamatud(), mis väljastab kogu info nende raamatute kohta, mis on kirjutatud selles keeles, mis kasutaja sisestas;
  7) väljstaKõikRaamatud(), mis väljastab kogu info kõigi raamatute kohta.

Alustasime projekti kuskil märtsi keskel, kui Marie tegi ära kõigi klasside alguse (umbkaudsed isendid ja kontruktorid), et mõte hakkaks liikuma. Järgmisena tegi Carmen ära failist ramatud.txt lugemise. Peale seda täiendas jälle Marie tehes nii, et failist lugemisel raamat õigesse riiulisse paigutatakse ning lõpks lisas Carmen kasutajaga suhtlemise (ning Marie kirjutas antud faili). Kõigi etappide ajal käis ka omavaheline ideede vahetus.
Raske on kirjeldada iga rühmaliikme panust, sest üks võis teha meetodi, kuid teine muutis seda hilisemas protsessis. Näiteks klassi Raamat meetodid olid Carmeni poolt tehtud, kuid Marie muutis neid, et oleks võimalik raamat riiulisse panna. Aga üldjoontes klassi Raamat meetodid lõi Carmen ja klassi Raamaturiiul meetodid lõi Marie. Tundides sai umbkaudu tehtud kokku 16 vms, mis sai suhteliselt võrdselt ära jaotatud, Carmen vist tegi natuke rohkem tööd reaalse koodiga, aga kõik teksti failid (k.a. see fail) on Marie loodud.
Põhiliseks muredeks oli failist lugemine ning kuidas tekitada sellest vastavad objektid ja kohati ka teineteise kirjutaud koodi täielik mõistmine/kohandamine. Kidlasti leidus ka ajapuudust, sest eriolukorra pealetulekuga suurnes nii mõnelgi õpikoormus märgatavalt (iseõppimine ei ole nii lihtne) ning seega tekkis ka suuremate töödega ajapuudust.
Kindlasti vajab veel arendamist klassi Riiul kasutamine, sest hetkel luuakse iga raamatu jaoks uus riiul, aga ideaalis võiks kasutada eksisteerivat riiulit. 
Programmi testisime printides saadud listid välja peale iga muudatust ning vaatasime kas tuleb see, mis pidi. Samuti sai kontrollitud, et kui printidaa listist ainult kindla omadusega asjad, kas ka siis tuleb välja soovitu. Üldiselt oligi testimise põhimõtteks kõige väljaprintimine.
