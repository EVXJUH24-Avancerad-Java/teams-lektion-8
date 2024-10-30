---
author: Lektion 8
date: MMMM dd, YYYY
paging: "%d / %d"
---

# Teams lektion 8

Hej och välkommen!

## Agenda

1. Frågor och repetition
2. Quiz frågor om reflection och annotations
3. Genomgång av övningar
4. Avstämning kring avancerade koncept
5. Övning med handledning

---

# Fråga

(Om readAnyObjectFromFile från lek 7)
Den kollar om typen är av String, Integer osv, men hur ska den veta om det är ett annat objekt och inte bara en variabel i klassen som skickades in? Tänkte om man sparat objekt i objekt till fil.

# Svar

Om typen inte är primitiv (int, double) eller en sträng så är det ett objekt. Jag visar när vi går igenom övningen.

---

# Fråga

Kan du visa igen hur man bjuder in till git om repositoriet är privat? Och hur man lämnar in git-länk på omniway.

# Svar

GitHub -> Repo -> Settings -> Collaborators

Kopiera länk och skicka.

---

# Fråga

Skulle du kunna gå igenom övning två och tre på Generics och lambdas?

# Svar

Det kan vi göra mot slutet när vi har gått igenom reflection och annotations övningar.

---

# Fråga

Kan du gå igenom annotation uppgift 3 också när du gått igenom resten av reflection övning 3?

# Svar

Det gör vi!

---

# Fråga

Kommer vi använda oss av Spring i framtiden?

# Svar

Ja.

---

# Reflection quiz

1. Vad är reflection?
2. Vilka två sätt finns det att hämta ut `Class<T>`?
3. Vad är det för skillnad mellan `getDeclaredFields` och `getFields`?
4. Vad måste göras för att komma åt privata saker med reflection?
5. När och varför skriver man `clazz`?

---

# Annotations quiz

1. Hur vet man om något är en annotation?
2. Hur skapar man en ny och egen annotation?
3. Hur lägger man till värden/fält i annotationer?
4. Vad innebär det om en annotation har en metod, och endast en metod, som heter `value`?
