# Lab 1: Filmy, lista i szczegóły

Projekt startowy z listą 10 filmów i miejscem na ekran szczegółów. Korzysta z Kotlin,
layoutów XML i View Binding. Zadanie jest przewidziane na około 30 minut.

## Uruchomienie

1. W Android Studio wybierzcie **File → Open** i otwórzcie folder z `settings.gradle.kts`.
2. Użyjcie zgodnego Gradle JDK wybranego w ustawieniach Android Studio, np. wbudowanego
   JDK. Projekt generuje kod JVM 17.
3. Zainstalujcie Android SDK Platform 36 i poczekajcie na zakończenie synchronizacji Gradle.
4. Wybierzcie emulator lub urządzenie z Androidem 7.0 (API 24) lub nowszym i kliknijcie **Run**.

Pojawi się lista filmów. W wersji startowej kliknięcie filmu jeszcze nic nie robi.
Konfiguracja, adapter, dane, Toolbar i obsługa wcięć systemowych są już przygotowane.

## Zadania

Wykonajcie komentarze `TODO` w kolejności od 1 do 5.
Pliki Kotlin znajdują się w `app/src/main/java/com/example/zadanielab1`,
a layouty w `app/src/main/res/layout`.

1. **Uzupełnijcie layout szczegółów** (`fragment_movie_details.xml`). Dodajcie `TextView`
   opisu z ID `text_description`, szerokością `0dp`, constraintami start/end/top,
   odstępem pod reżyserem i tekstem podglądu `tools:text`. Kontener przewijania jest gotowy.
2. **Przekażcie ID filmu** (`ui/details/MovieDetailsFragment.kt`, `newInstance`).
   Zapiszcie ID w argumentach fragmentu przez `Bundle.putInt`, używając `ARG_MOVIE_ID`.
3. **Otwórzcie szczegóły** (`ui/list/MovieListFragment.kt`, `openDetails`).
   W transakcji `parentFragmentManager.commit` włączcie `setReorderingAllowed(true)`,
   zastąpcie listę w `fragment_container` przez `replace` i użyjcie `addToBackStack(null)`.
4. **Wyświetlcie wybrany film** (`ui/details/MovieDetailsFragment.kt`, `onViewCreated`).
   Odczytajcie ID, pobierzcie film z `MovieRepository` i uzupełnijcie przez View Binding
   tytuł, rok/gatunek, reżysera, ocenę i opis. Użyjcie gotowych zasobów formatujących tekst.
5. **Obsłużcie powrót** (`MainActivity.kt`). Pokazujcie strzałkę Toolbar Up tylko na
   szczegółach. Sprawdzajcie aktualny fragment po zmianie stosu oraz przy tworzeniu Activity,
   także po obrocie. Kliknięcie strzałki powinno wywołać `popBackStack`.

## Oczekiwany efekt

Kliknięcie dowolnego filmu otwiera jego szczegóły. Systemowy Wstecz i strzałka w Toolbarze
przywracają listę, na której strzałka znika. Obrót ekranu zachowuje wybrany film i poprawny
stan strzałki, a na liście nie dodaje kolejnego fragmentu. Opis można przewinąć również
w orientacji poziomej i przy większym rozmiarze tekstu.

## Sprawdzenie rozwiązania

Wybierzcie emulator lub podłączcie urządzenie. W Android Studio otwórzcie klasę
`MovieExerciseTest` w `app/src/androidTest` i uruchomcie ją zieloną strzałką obok nazwy.
Z terminala można uruchomić cały zestaw testów urządzenia:

```sh
./gradlew connectedDebugAndroidTest
```

Testy `MovieExerciseTest` celowo nie przechodzą w wersji startowej. Sprawdzają opis,
argumenty, wybrany film, powrót oraz odtworzenie Activity. Komunikaty wskazują odpowiednie
zadania. Część testów wymaga wykonania wcześniejszych zadań, zwłaszcza otwierania szczegółów.
Po ukończeniu ćwiczenia wszystkie powinny przechodzić.
Test `MainActivityTest` sprawdza gotową listę i powinien przechodzić już w starterze.
