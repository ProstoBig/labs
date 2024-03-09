package lab;

interface Instrument {
    void play();
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

class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println(" на піаніно\n");
    }
}

class Violin implements Instrument {
    @Override
    public void play() {
        System.out.println(" на скрипці\n");
    }
}

class Synthesizer implements Instrument {
    @Override
    public void play() {
        System.out.println(" на синтезаторі\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Violin violin = new Violin();
        Synthesizer synthesizer = new Synthesizer();

        Musician musician = new Musician("Джо");
        Musician musician1 = new Musician("Байден");

        musician.playInstrument(piano);
        musician1.playInstrument(violin);
        musician.playInstrument(synthesizer);
    }
}