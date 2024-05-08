Fortgeschrittene Programmierung (Java 2)

# Übung 4


## a) Repository klonen und Branch erstellen

Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen. Idealerweise machen Sie für jede Teilaufgabe einen Commit, so dass Sie hinterher (mindestens) 2 Commits pushen. Sie können natürlich beliebig viele weitere commits machen, wenn Sie möchten.

## b) Aufgabe 1

Als Basiscode innerhalb des Projektes finden Sie eine Referenzlösung aus Übung 2 (nämlich die, in der die Konten eigene Objekte sind, und das Array nach dem Konto mit der passenden Kontonummer durchsucht wird). Wenn Sie lieber Ihre eigene Lösung für die Aufgabe verwenden möchten, kopieren Sie sie herein, und machen direkt einen Git-Commit, um diese erste Änderung festzuhalten.

Wir wenden unser neu gewonnenes Wissen über Iteratoren jetzt auf die Kontos unserer fiktiven Bank an. Bisher waren die Konten ja in einem Array gespeichert, und das Array wurde durchsucht. 

Fügen Sie eine neue Klasse `AccountIterator implements Iterator<Account>` hinzu, um über die Konten zu iterieren. Diese Iterator-Klasse kann eine normale Klasse sein, die neben `Account` und `ATM` liegt, sie kann aber auch als [inner class](https://dh-cologne.github.io/java-wegweiser/articles/Innere-und-anonyme-Klassen.html) von `ATM` realisiert werden. Implementieren Sie auch den Zugriff auf das Konto über eine `while`-Schleife mithilfe des Iterators.	

Machen Sie einen Commit, wenn Sie Aufgabe 1 abgeschlossen haben.

## c) Aufgabe 2

Dass die Konten innerhalb des Geldautomaten gespeichert sind, ist ja keine sehr realistische Annahme. Ändern Sie den Code daher wie folgt:

1. Fügen Sie eine neue Klasse `Bank` hinzu, die eine Anzahl an Konten speichern kann. Ein Geldautomat speichert dann eine Referenz auf eine Bank, anstelle der einzelnen Konten. Welcher Bank ein Geldautomat gehört, bekommt der Konstruktor des Geldautomaten übergeben. 
2. Machen Sie die Bank nun `Iterable<Account>` und verwenden Sie innerhalb des Geldautomaten die `for`-Schleife mit Doppelpunkt (`for (Account account : bank) { ... }`) um das Konto zu suchen. Auch hier können Sie die Iterator-Klasse wieder als inner class realisieren. 

Machen Sie einen Commit, wenn Sie Aufgabe 2 abgeschlossen haben.

## d) Push
Pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 