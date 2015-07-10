# JsonLocalization
"On the fly" localization for Android apps

Inspired from a similar library for iOS: https://github.com/Baglan/MCLocalization

## File / Data format

It uses strings files in JSON format.

Example:

	{
	    "en": {
	        "NAME" : "English Name",
	        "PRICE": "€ 0.99" 
	    },
	    "nl": {
	        "NAME" : "Dutch Name"
	        "PRICE": "€ 0,99" 
	    }
	}

## Usage

Initialize localization by loading strings:
(It automatically detects language from the device)

Strings could be loaded on the fly from a server, or could be saved in a file in the app's directory

```Java
// Setup:
// Load from string
JsonLocalization.getInstance().loadFromData(jsonString);

// OR Load from filename 
JsonLocalization.getInstance().loadFromFileName(context, "localize.json");

// Localize:
String localizedString = JsonLocalization.getInstance().stringForKey(key);
```

If `key` is not found, `key` is the default value returned.

----
Developed at www.walletcircle.com
