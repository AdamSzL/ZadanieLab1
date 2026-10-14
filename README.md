# Lab 1 – Filmy: lista i szczegóły

Projekt startowy do Laboratorium 1 (podstawy Androida, layouty XML, Activity i Fragmenty).
Aplikacja wyświetla listę filmów. Waszym zadaniem jest otwarcie ekranu szczegółów wybranego
filmu oraz poprawna obsługa powrotu do listy.

## Wymagania

Przygotujcie środowisko **przed zajęciami**:
- Android Studio (najnowsza stabilna wersja)
- JDK 17 lub 21 (wystarczy JDK wbudowane w Android Studio)
- Android SDK Platform 36 (Android 16), do zainstalowania w *Settings → Languages & Frameworks → Android SDK*
- emulator lub fizyczne urządzenie z Androidem 7.0 (API 24) lub nowszym

## Pobranie i uruchomienie projektu

1. Pobierzcie projekt:
   ```
   git clone https://github.com/AdamSzL/ZadanieLab1.git
   ```
   albo na GitHubie wybierzcie *Code → Download ZIP* i rozpakujcie archiwum.
2. W Android Studio wybierzcie *File → Open* i wskażcie folder projektu.
3. Poczekajcie na zakończenie synchronizacji Gradle. Przy pierwszym uruchomieniu pobierze się Gradle 8.14.3 i Build Tools, co może potrwać kilka minut.
4. Wybierzcie urządzenie i kliknijcie **Run**.

Powinna pojawić się lista 10 filmów. Kliknięcie filmu na razie nic nie robi i tak ma być.

## Struktura projektu

```
app/src/main/
├── java/com/example/zadanielab1/
│   ├── MainActivity.kt              # jedyna Activity: Toolbar + FragmentContainerView
│   ├── data/
│   │   ├── Movie.kt                 # model danych
│   │   └── MovieRepository.kt       # przykładowe dane
│   └── ui/
│       ├── list/
│       │   ├── MovieListFragment.kt # ekran listy (RecyclerView)
│       │   └── MovieAdapter.kt
│       └── details/
│           └── MovieDetailsFragment.kt
└── res/layout/
    ├── activity_main.xml
    ├── fragment_movie_list.xml
    ├── item_movie.xml
    └── fragment_movie_details.xml
```

## Zadanie (~30 min)

Znajdźcie w kodzie komentarze `TODO`. Każdy z nich zawiera krótką wskazówkę (po angielsku).
Sugerowana kolejność to **1 → 2 → 4 → 3 → 5**, ponieważ ekran szczegółów zobaczycie dopiero po wykonaniu TODO 2 i TODO 4.

| TODO | Plik | Co zrobić |
|---|---|---|
| 1 | `fragment_movie_details.xml` | Dodać `TextView` na opis filmu i ustawić go za pomocą constraintów. |
| 2 | `MovieDetailsFragment.kt` | Przekazać identyfikator filmu do fragmentu przez jego argumenty w `newInstance()`. |
| 3 | `MovieDetailsFragment.kt` | Odczytać identyfikator, pobrać film z `MovieRepository` i wyświetlić jego szczegóły. |
| 4 | `MovieListFragment.kt` | Otworzyć ekran szczegółów transakcją fragmentu (`replace` + `addToBackStack`). |
| 5 | `MainActivity.kt` | Pokazać strzałkę „wstecz” w Toolbarze na ekranie szczegółów i obsłużyć jej kliknięcie (`popBackStack`). |

## Oczekiwany efekt

- Kliknięcie filmu na liście otwiera jego szczegóły: tytuł, rok, gatunek, ocenę, reżysera i opis.
- Systemowy przycisk „wstecz” wraca do listy.
- Na ekranie szczegółów Toolbar pokazuje strzałkę „wstecz”, która również wraca do listy. Na liście strzałka nie jest widoczna.
- Po obróceniu ekranu na ekranie szczegółów nadal wyświetla się ten sam film i strzałka.
