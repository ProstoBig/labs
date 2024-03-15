package lab;

import java.util.ArrayList;

interface Instrument {
    void play();
}

interface Tunable {
    void tune();
}

class Musician {
    String name;
    ArrayList<Instrument> instruments;

    public Musician(String name) {
        this.name = name;
        this.instruments = new ArrayList<>();
    }

    void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    void playInstruments() {
        if (instruments.isEmpty()) {
            System.out.println(name + " не має інструментів для гри.");
            return;
        }
        System.out.print(name + " грає на:");
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    void tuneInstruments() {
        if (instruments.isEmpty()) {
            System.out.println(name + " не має інструментів для налаштування.");
            return;
        }
        System.out.println(name + " налаштовує свої інструменти:");
        for (Instrument instrument : instruments) {
            if (instrument instanceof Tunable) {
                ((Tunable) instrument).tune();
            }
        }
    }
}

class Piano implements Instrument, Tunable {
    @Override
    public void play() {
        System.out.print(" піаніно");
    }

    @Override
    public void tune() {
        System.out.println("Струни піаніно налаштовані.");
    }
}

class Violin implements Instrument, Tunable {
    @Override
    public void play() {
        System.out.print(" скрипці");
    }

    @Override
    public void tune() {
        System.out.println("Струни скрипки налаштовані.");
    }
}