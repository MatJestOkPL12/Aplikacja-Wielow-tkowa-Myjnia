Podczas laboratorium należy zbudować aplikację, w której dojdzie do synchronizacji wielu wątków. Aplikacja powinna być parametryzowana i pozwalać na uruchamianie wątków oraz obserwowanie ich zachowań i stanów.
Zakładamy, że aplikacja będzie pełnić rolę symulator samoubsługowej myjni samochodowej.
Na myjnię samochodową można wjechać jedną z dwóch bram. Przy każdej bramie obowiązuje kolejka w oczekiwaniu na wolne stanowisko. Decyzja o tym, przez którą bramę wjechać jest podejmowana na podstawie oceny długości kolejek (zwykle wybierana jest kolejka o mniejszej długości).
Pojazdy znajdujące się w kolejkach są wpuszczane na wolne stanowiska przez Kontrolera. Kontroler zwykle naprzemiennie wpuszcza Pojazdy znajdujące się na pierwszych pozycjach w kolejkach. Aby to nastąpiło musi istnieć wolne Stanowisko.
Istnieje n Stanowisk ustawionych w szereg. Pomiędzy Stanowiskami znajdują się po dwie myjki: jedną z wodą i drugą z płynem (każde dwa stanowiska współdzielą dwie myjki znajdujące się między nimi, stąd na skrajnych stanowiskach można skorzystać z dwóch myjek, podczas gdy na stanowiskach w środku - z czterech myjek).
Mycie składa się z trzech faz: użycia myjki z wodą, użycia myjki z płynem, użycia myjki z wodą. Dostęp do myjek powinien odbywać się z wzajemnym wykluczaniem.
Po zakończeniu wszystkich trzech faz mycia Pojazd opuszcza myjnię. Po jakimś czasie Pojazd może wrócić na myjnię.
