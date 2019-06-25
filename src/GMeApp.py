# Developed by James Brancale
# 25 June 2019
# Python 3.6

import requests

def main():
    print("--------------------------\nWelcome to the GroupMe app\n--------------------------\n"
          "In order to use this application, go to https://dev.groupme.com/"
          "\nand generate an access token\n\nDISCLAIMER: The developer of"
          "\nthis application is not\n"
          "responsible for any loss of data\n--------------------------\n")

    validate = True

    while (validate):
        # Request access token from user
        userkey = input("Please enter your GroupMe access token: ")

        GMeURL = "https://api.groupme.com/v3/users/me?token=" + userkey

        r = requests.get(GMeURL)

        # extracting data in json format
        userData = r.json()

        isValid = input("The email associated with this login is: \n" + userData["response"]["email"] + "\n"
                        "is this correct? (Y/N): ")
        while (True):

            if (isValid.lower() == 'y'):
                validate = False
                break;
            elif (isValid.lower() == 'n'):
                print("You will be logged out of this account...\n")
                break;
            else:
                isValid = input("Input must be Y for yes or N for no: ")
                continue

    print("\nYou are now logged in.")

if (__name__ == "__main__"):
    main()