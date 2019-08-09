# bitmap-transformer# bitmap-transformer
                    - use ./gradlew run --args input-file-path output-file-path transform-number to run tests from command line
                     - input-file-path - file path of the input bitmap(.bmp) file
                     - output-file-path - is where the transformed file will be written to
                     - transform-number - 1. Move horizontally, 2. Flip vertically, 3. Change pixel colors in right half of the bmp file
                     - use one or two or three for the transform number
                    
                     Example:  ./gradlew run --args ./assets/coffee.bmp ./assets/coffeeNew.bmp one