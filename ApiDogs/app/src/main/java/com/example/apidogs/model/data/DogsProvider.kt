package com.example.apidogs.model.data

import com.example.apidogs.model.data.Dog

class DogsProvider {

    fun getAllDogs(): DogList = DogList(dogsList)

    private val dogsList = mutableListOf<Dog>(
        Dog("Affenpinscher",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_2559.jpg",
            ""),
        Dog(
            "African",

            "https://github.com/jigsawpieces/dog-api-images/blob/main/african/n02116738_10614.jpg?raw=true",
            ""
        ),
        Dog(
            "Airedale",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/airedale/n02096051_1110.jpg?raw=true",
            ""
        ),
        Dog(
            "Akita",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/akita/Akita_inu_blanc.jpg?raw=true",
            ""
        ),
        Dog(
            "Basenji",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/basenji/n02110806_1102.jpg?raw=true",
            ""
        ),
        Dog(
            "Beagle",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/beagle/1271553739_Milo.jpg?raw=true",
            ""
        ),
        Dog(
            "Bluetick",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/bluetick/n02088632_101.jpg?raw=true",
            ""
        ),
        Dog(
            "Bouvier",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/bouvier/n02106382_1000.jpg?raw=true",
            ""
        ),
        Dog(
            "Boxer",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/boxer/n02108089_11032.jpg?raw=true",
            ""
        ),
        Dog(
            "Bulldog English",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/bulldog-english/jager-1.jpg?raw=true",
            ""
        ),
        Dog(
            "Bulldog French",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/bulldog-french/n02108915_12317.jpg?raw=true",
            ""
        ),
        Dog(
            "Bullterrier Staffordshire",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/bullterrier-staffordshire/n02093256_11820.jpg?raw=true",
            ""
        ),
        Dog(
            "Cattledog Australian",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/cattledog-australian/IMG_1042.jpg?raw=true",
            ""
        ),
        Dog(
            "Cavapoo",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/cavapoo/lulu2.jpg?raw=true",
            ""
        ),
        Dog(
            "Black Chihuahua",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/chihuahua/black_chihuahua.jpg?raw=true",
            ""
        ),
        Dog(
            "Collin",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/collie/n02106030_10170.jpg?raw=true",
            ""
        ),
        Dog(
            "Clumber",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/clumber/n02101556_2023.jpg?raw=true",
            ""
        ),
        Dog(
            "dalmatian",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/chihuahua/black_chihuahua.jpg?raw=true",
            ""
        ),
        Dog(
            "cordiCardigan",
            "https://github.com/jigsawpieces/dog-api-images/blob/main/collie/n02106030_10170.jpg?raw=true",
            ""
        ),
    )
}