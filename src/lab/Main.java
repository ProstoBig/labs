package lab;

interface Instrument {
    void play();
}

interface Tunable {
    void tune();
}

class Musician {
    String name;
    public Musician(String name) {
        this.name = name;
    }
    void playInstrument(Instrument instrument) {
        System.out.print(name + " грає");
        instrument.play();
    }
}

class Piano implements Instrument, Tunable {
    @Override
    public void play() {
        System.out.println(" на піаніно");
    }

    @Override
    public void tune() {
        System.out.println("Струни піаніно налаштовані.");
    }
}

class Violin implements Instrument, Tunable {
    @Override
    public void play() {
        System.out.println(" на скрипці");
    }

    @Override
    public void tune() {
        System.out.println("Струни скрипки налаштовані.");
    }
}

public class Main {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Violin violin = new Violin();

        Musician musician = new Musician("Джо");
        Musician musician1 = new Musician("Байден");

        musician.playInstrument(piano);
        musician1.playInstrument(violin);

        if (piano instanceof Tunable) {
            ((Tunable) piano).tune();
        }
        if (violin instanceof Tunable) {
            ((Tunable) violin).tune();
        }
    }
}