# Wireworld
Wireworld to automat komórkowy zaproponowany przez Briana Silvermana w roku 1987

### Zasada działania
Komórka w Wireworld może znajdować się w jednym z czterech stanów:
* pusta
* głowa elektronu
* ogon elektronu
* przewodnik

Upływ czasu przedstawiony jest w postaci dyskretnych kroków czasowych, czyli generacji. Komórka pusta na zawsze pozostaje w swoim stanie; inne komórki zachowują się w następujący sposób:
* Głowa elektronu → ogon elektronu;
* Ogon elektronu → przewodnik;
* Przewodnik → głowa elektronu, ale tylko wtedy, gdy dokładnie 1 lub 2 komórki sąsiadujące są głowami elektronu.

Stosowane sąsiedztwo to sąsiedztwo Moore’a, czyli sąsiadem jest każda komórka, która graniczy bokiem lub wierzchołkiem. 
