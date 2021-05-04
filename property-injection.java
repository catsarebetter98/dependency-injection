// Property injection is used when you may not need a required dependency but
// an optional one.

// Interface to declare the method that we'll inject into Document

interface GrammarChecker {
  CheckGrammar(): void;
}

// We need an optional dependency and a default in case the dependency isn't
// injected.
class defaultGrammarChecker implements IGrammarChecker {
  public CheckGrammar() {
    console.log('Do Nothing');
  }
}

class realGrammarChecker implements IGrammarChecker {
  CheckGrammar() {
    console.log('Grammar has been checked');
  }
}

// Here is the Document class, we set the default option in the constructor
// then we'll let the code that declares an instance of the class inject
// a dependency: IGrammarChecker, in the setter.
class Document {
    private _text: string;

    private _grammarChecker: IGrammarChecker;

    set grammarChecker(value: IGrammarChecker) {
      CheckNeitherNullNorUndefined(value);
      this._grammarChecker = value;
    }

    public constructor(aText: string) {
      this._text = aText;
      this._grammarChecker = new defaultGrammarChecker();
    }

    set text(value: string) {
      this._text = value;
    }

    get text(): string {
      return this._text;
    }

    public CheckGrammar() {
      this._grammarChecker.CheckGrammar();
    }
  }

  // Implementation

  var document: Document = new Document('This is the document text.');

  console.log(document.text);
  // Use the default, no-op grammar checker
  document.CheckGrammar();
  // Change the dependency to use the "real" grammar checker
  document.grammarChecker = new realGrammarChecker();
  // Now the grammar checker is a "real" one
  document.CheckGrammar();
