package com.example.android.jokes;

import java.util.Random;

public class Jokes {

    private final String[] jokes = new String[] {
            "A neutron walks into a bar and orders a drink. \nWhen the neutron gets his drink, he asks, " +
                    "\"Bartender, how much do I owe you?\"\n" +
                    "The bartender replies, \n\"For you, neutron, no charge.\" ",

            "Q: What did the guy's carphone answering machine say?\n" +
                    "\n" +
                    "A: \"Hi, I'm home right now so I can't take your call.\"",

            "A few days after her husband's death, a grieving widow accidentally receives an e-mail from a man waiting for his wife in Miami.\n" +
                    "\n" +
                    "The e-mail reads:\n" +
                    "\n" +
                    "Dearest Wife,\n" +
                    "\n" +
                    "Just got checked in. Everything prepared for your arrival tomorrow.\n" +
                    "\n" +
                    "P.S. Sure is hot down here.",

            "A couple of weeks ago I got a call -- typical telemarketer. \n" +
                    "He said, 'Are you happy with your long distance service?' \n" +
                    "And I said, 'Now this is an insane coincidence.' \n" +
                    "And he said, 'What?' \n" +
                    "And I said, 'I also work for a long distance phone company.' \n" +
                    "And he was like, 'Really?' \n" +
                    "And I said, 'Yeah.' \n" +
                    "And we laughed and we laughed at what a coincidence that was, and then I said, \n" +
                    "'Well, look, while I got you on phone -- are you happy with your long distance service? Because I've got a calling plan that could just shave dollars off your monthly bill.'",

            "UNIX is user friendly. It's just very particular about who its friends are.",

            "I wasn't always a comic. \n" +
                    "Before I did this, I was a house painter for five years. \n" +
                    "Five years -- I didn't think I'd ever finish that house.",

            "I bought a $6 million house. \n" +
                    "I got a great deal on it: I put down $400; \n" +
                    "I have a mortgage of $31,000 every month. \n" +
                    "My idea is to live there for three months until they throw me the hell out of there."
    };

    public Jokes() {

    }

    public String getJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
