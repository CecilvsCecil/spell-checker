Spell-checker implemented using a hash table. Checks for spelling errors in an input file, referencing a provided dictionary file. 
 
METHODS
* ```public SpellChecker(String filename)``` - This is the constructor; it takes in a String of the file name of the dictionary.

* ```public List<String> getIncorrectWords(String filename)``` - returns a list of all words in the input file that are incorrectly spelled according to the dictionary file provided to the constructor. The String ```filename``` contains the name of the file to be spell-checked.

* ```public Set<String> getSuggestions(String word)``` - returns a set of all potential suggestions for the incorrectly spelled word that is provided as input. If there are no valid suggestions, returns an empty set.

In order to generate a suggestion for a given word, the following spell checking techniques are used, where a character is defined as one of `a, b, c, ..., z`:

* Add one character - add a character at every point in the string (including at the very beginning and end)
* Remove one character - remove one character at a time from each position in the string
* Swap adjacent characters - swap every pair of adjacent characters in the string
