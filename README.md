# Ryhmatöö
Midagi ESTERi-sarnast, aga isiklikule raamatukogule

Koos programmiga (ja vajalike lisafailidega) tuleb esitada ka oma rühmatöö kirjeldus, kus peavad olema

autorite nimed;
projekti põhjalik kirjeldus, kus on kirjas programmi eesmärk ja selgitus programmi üldisest tööst, vajadusel lühike kasutusjuhis;
iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid;
projekti tegemise protsessi kirjeldus (erinevad etapid ja rühmaliikmete osalemine neis);
iga rühmaliikme panus (sh tehtud klassid/meetodid) ja ajakulu (orienteeruvalt);
tegemise mured (nt millistest teadmistest/oskustest tundsite projekti tegemisel puudust);
hinnang oma töö lõpptulemusele (millega saite hästi hakkama ja mis vajab arendamist);
selgitus ja/või näited, kuidas programmi osi eraldi ja programmi tervikuna testisite ehk kuidas veendusite, et programm töötab korrektselt.


autorid: Carmen Akkermann ja Marie Tempel

Programmi üldine eesmärk on aidata orienteeruda koduses raamatukogus, näiteks kui inimene omab ligi tuhat raamatut, siis tuleks kasuks, kui saaks otsida mingi programmi abil, kas kindel raamat on inimesel juba olemas või kus see asub.

Meil on klass Raamat, kus on kirjas kõik raamatu andmed. Meetodid loeRaamatudFailist ja isenditeLoomineJaListiLisamine loevad failist raamatud.txt andemed raamatute kohta ning tekitavad vastavad objektid ning lisavad listi List<Raamat> kõigiRaamatuteList. 
Eraldi on tehtud alamklass TolkeRaamat, kus on siis lisaks üldisele kirjas ka tõlkja, originaal pealkiri ja muu ainult tõlke raamatule omapärane. Samuti on veel klassid Raamaturiiul ja Riiul. Tõlkeraamatus ei ole eraldi olulisi meetoteid, tõlkeraamat luuakse klassi Raamat meetodis isenditeLoomineJaListiLisamine.
Klassis Raamaturiiul on kindla riiuli tunnusjooned nagu kui suur riiul on ja mis eristab seda teistest. Sarnaselt klassile Raamat on ka elles klassis meetodid loeRiiulidFailist ja riiuliIsenditeLoomineJaListiLisamine, mis loevad ette antud failis riiulid.txt andmed ning muudavad need Raamaturiiulite listiks.
Klassis Riiul on eraldi märge täpse asukoha kohta ja viide Raamaturiiulile, kus asub antud raamat (märge asukohale on maatriksi kordinaatidena). Ka klassis Riiul puuduvad tähtsamad meetodid. Riiul on nüüd täpsemalt see, mis käib Raamatu kirjesse.
Alustasime projekti kuskil märtsi keskel, kui Marie tegi ära kõigi klasside alguse (umbkaudsed isendid ja kontruktorid), et mõte hakkaks liikuma. Järgmisena tegi Carmen ära failist ramatud.txt lugemise. Peale seda täiendas jälle Marie tehes nii, et failist lugemisel raamat õigesse riiulisse paigutatakse ning lõpks lisas Carmen kasutajaga suhtlemise (ning Marie kirjutas antud faili). Kõigi etappide ajal käis ka omavaheline ideede vahetus.
  
Raske on kirjeldada iga rühmaliikme panust, sest üks võis teha meetodi, kuid teine muutis seda hilisemas protsessis. Näiteks klassi Raamat meetodid olid Carmeni poolt tehtud, kuid Marie muutis neid, et oleks võimalik raamat riiulisse panna. Aga üldjoontes klassi Raamat meetodid lõi Carmen ja klassi Raamaturiiul meetodid lõi Marie. Tundides sai umbkaudu tehtud kokku kuskil 15, mis sai suhtkoht võrdselt ära jaotatud, Carmen vist tegi natuke rohkem tööd reaalse koodiga, aga kõik teksti failid (k.a. see fail) on Marie loodud.
Põhiliseks muredeks oli failist lugemine ning kuidas tekitada sellest vastavad objektid. Kidlasti leidus ka ajapuudust, sest eriolukorra pealetulekuga suurnes nii mõnelgi õpikoormus märgatavalt (iseõppimine ei ole nii lihtne) ning seega tekkis ka suuremate töödega ajapuudust.
Kindlasti vajab veel arendamist klassi Riiul kasutamine, sest hetkel luuakse iga raamatu jaoks uus riiul, aga ideaalis võiks kasutada eksisteerivat riiulit. 
Programmi testisime printides saadud listid välja peale iga muudatust ning vaatasime kas tuleb see, mis pidi. Samuti sai kontrollitud, et kui printidaa listist ainult kindla omadusega asjad, kas ka siis tuleb välja soovitu. Üldiselt oligi testimise põhimõtteks kõige väljaprintimine.
