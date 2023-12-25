package com.code.range.bookworm

import com.code.range.bookworm.data.network.GoogleBookApi
import com.code.range.bookworm.data.network.dto.RemoteBook
import com.code.range.bookworm.data.network.dto.RemoteBookList
import com.google.gson.Gson
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockGoogleBooksApi: GoogleBookApi {
    override fun getBook(id: String): Call<RemoteBook> {
//        return object: Call<RemoteBook> {
//            override fun clone(): Call<RemoteBook> {
//                TODO("Not yet implemented")
//            }
//
//            override fun execute(): Response<RemoteBook> {
//                return Response.success(Gson().fromJson(mockGetBooksSampleJson,
//                                                        RemoteBookList::class.java))
//            }
//
//            override fun isExecuted(): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun cancel() {
//                TODO("Not yet implemented")
//            }
//
//            override fun isCanceled(): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun request(): Request {
//                TODO("Not yet implemented")
//            }
//
//            override fun timeout(): Timeout {
//                TODO("Not yet implemented")
//            }
//
//            override fun enqueue(callback: Callback<RemoteBook>) {
//                TODO("Not yet implemented")
//            }
//        }
        TODO()
    }

    override fun getBooks(query: String): Call<RemoteBookList> {
        return object : Call<RemoteBookList> {
            override fun clone(): Call<RemoteBookList> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<RemoteBookList> {
                val objectToRespond = Gson().fromJson(mockGetBooksSampleJson,
                                                      RemoteBookList::class.java)
                return Response.success(
                    objectToRespond
                )
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<RemoteBookList>) {
                TODO("Not yet implemented")
            }

        }
    }
}

private val mockGetBooksSampleJson = "{\"kind\":\"books#volumes\",\"totalItems\":2435,\"items\":[{\"kind\":\"books#volume\",\"id\":\"SI4TEAAAQBAJ\",\"etag\":\"Iuf/PEubFhk\",\"selfLink\":\"https://www.googleapis.com/books/v1/volumes/SI4TEAAAQBAJ\",\"volumeInfo\":{\"title\":\"Urban Quilting\",\"authors\":[\"Wendy Chow\"],\"publisher\":\"Blue Star Press\",\"publishedDate\":\"2021-01-19\",\"description\":\"Perfect for beginners, this quilting book features simple illustrations and easy-to-follow steps that teach you how to make up to 30 beautiful quilts in a short amount of time! A comprehensive guide for both first-time quilters and those looking for a refresher course, Urban Quilting teaches you everything you need to know about this timeless craft. Each pattern contains instructions for three different quilt sizes, with designs that feature bold colors and geometric shapes that will stand out and look stunning in your home. Urban Quilting includes: 10 quilt designs, each with patterns for 3 sizes, for making up to 30 quilts Beginner-friendly content, including everything you need to know to get started Detailed instructions with clear diagrams so you can learn quickly and easily Insightful information on the history of quilting and how today's quilters are modernizing the craft\",\"industryIdentifiers\":[{\"type\":\"ISBN_13\",\"identifier\":\"9781950968428\"},{\"type\":\"ISBN_10\",\"identifier\":\"1950968421\"}],\"readingModes\":{\"text\":true,\"image\":true},\"pageCount\":166,\"printType\":\"BOOK\",\"categories\":[\"Crafts & Hobbies\"],\"maturityRating\":\"NOT_MATURE\",\"allowAnonLogging\":true,\"contentVersion\":\"0.3.2.0.preview.3\",\"panelizationSummary\":{\"containsEpubBubbles\":false,\"containsImageBubbles\":false},\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=SI4TEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=SI4TEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"},\"language\":\"en\",\"previewLink\":\"http://books.google.com/books?id=SI4TEAAAQBAJ&printsec=frontcover&dq=quilting&hl=&cd=1&source=gbs_api\",\"infoLink\":\"https://play.google.com/store/books/details?id=SI4TEAAAQBAJ&source=gbs_api\",\"canonicalVolumeLink\":\"https://play.google.com/store/books/details?id=SI4TEAAAQBAJ\"},\"saleInfo\":{\"country\":\"US\",\"saleability\":\"FOR_SALE\",\"isEbook\":true,\"listPrice\":{\"amount\":12.99,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amount\":12.99,\"currencyCode\":\"USD\"},\"buyLink\":\"https://play.google.com/store/books/details?id=SI4TEAAAQBAJ&rdid=book-SI4TEAAAQBAJ&rdot=1&source=gbs_api\",\"offers\":[{\"finskyOfferType\":1,\"listPrice\":{\"amountInMicros\":12990000,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amountInMicros\":12990000,\"currencyCode\":\"USD\"},\"giftable\":true}]},\"accessInfo\":{\"country\":\"US\",\"viewability\":\"PARTIAL\",\"embeddable\":true,\"publicDomain\":false,\"textToSpeechPermission\":\"ALLOWED\",\"epub\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.com/books/download/Urban_Quilting-sample-epub.acsm?id=SI4TEAAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"pdf\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.com/books/download/Urban_Quilting-sample-pdf.acsm?id=SI4TEAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"webReaderLink\":\"http://play.google.com/books/reader?id=SI4TEAAAQBAJ&hl=&source=gbs_api\",\"accessViewStatus\":\"SAMPLE\",\"quoteSharingAllowed\":false},\"searchInfo\":{\"textSnippet\":\"Perfect for beginners, this quilting book features simple illustrations and easy-to-follow steps that teach you how to make up to 30 beautiful quilts in a short amount of time!\"}},{\"kind\":\"books#volume\",\"id\":\"WiqODwAAQBAJ\",\"etag\":\"KAdoxwbnHFA\",\"selfLink\":\"https://www.googleapis.com/books/v1/volumes/WiqODwAAQBAJ\",\"volumeInfo\":{\"title\":\"Shizuko Kuroha's Japanese Patchwork Quilting Patterns\",\"subtitle\":\"Charming Quilts, Bags, Pouches, Table Runners and More\",\"authors\":[\"Shizuko Kuroha\"],\"publisher\":\"Tuttle Publishing\",\"publishedDate\":\"2019-03-26\",\"description\":\"Shizuko Kuroha's Japanese Patchwork Quilting Patterns infuses a cherished American craft with an exquisite Japanese sense of color, detail, and design. This book brings a fresh eye to classic patchwork patterns in a way that is delighting quilters all around the world today. Here, Kuroha shares her intricate hand-quilting techniques and a design sense that has been refined over her 40-year career as a celebrated book author and teacher. Her easy combinations of soft colors, detailed patterns, and bold stripes show how to achieve balance and flow in any type of patchwork project--from the simplest to the most complex. Step-by-step illustrations walk quilters through Kuroha's intricate hand-piecework process. The book includes 19 sampler blocks used to make hundreds of different combinations for all kinds of quilting projects. The photos and diagrams of the block assembly are so clear, you hardly need to read the steps! A handy printable pattern sheet at the back of the book takes the labor out of drawing the pieces used to build these blocks. Detailed instructions show you how to incorporate the blocks into projects large and small, including: Pincushions in round and square designs Drawstring bags and zippered pouches embellished with patchwork Quilted tote bags and a stylish backpack Table runners and wall hangings with gorgeous color schemes Full-sized quilts destined to become cherished heirlooms This book is an invaluable introduction to the basics of hand-stitched piecework. Practiced quilters will also love it for the way it broadens their horizons. Kuroha fans will be happy to see this popular book finally available in English--where it's sure to become a treasured reference for years to come!\",\"industryIdentifiers\":[{\"type\":\"ISBN_13\",\"identifier\":\"9781462920723\"},{\"type\":\"ISBN_10\",\"identifier\":\"1462920721\"}],\"readingModes\":{\"text\":true,\"image\":true},\"pageCount\":117,\"printType\":\"BOOK\",\"categories\":[\"Crafts & Hobbies\"],\"maturityRating\":\"NOT_MATURE\",\"allowAnonLogging\":true,\"contentVersion\":\"1.5.5.0.preview.3\",\"panelizationSummary\":{\"containsEpubBubbles\":false,\"containsImageBubbles\":false},\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=WiqODwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=WiqODwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"},\"language\":\"en\",\"previewLink\":\"http://books.google.com/books?id=WiqODwAAQBAJ&printsec=frontcover&dq=quilting&hl=&cd=2&source=gbs_api\",\"infoLink\":\"https://play.google.com/store/books/details?id=WiqODwAAQBAJ&source=gbs_api\",\"canonicalVolumeLink\":\"https://play.google.com/store/books/details?id=WiqODwAAQBAJ\"},\"saleInfo\":{\"country\":\"US\",\"saleability\":\"FOR_SALE\",\"isEbook\":true,\"listPrice\":{\"amount\":18.99,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amount\":9.99,\"currencyCode\":\"USD\"},\"buyLink\":\"https://play.google.com/store/books/details?id=WiqODwAAQBAJ&rdid=book-WiqODwAAQBAJ&rdot=1&source=gbs_api\",\"offers\":[{\"finskyOfferType\":1,\"listPrice\":{\"amountInMicros\":18990000,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amountInMicros\":9990000,\"currencyCode\":\"USD\"},\"giftable\":true}]},\"accessInfo\":{\"country\":\"US\",\"viewability\":\"PARTIAL\",\"embeddable\":true,\"publicDomain\":false,\"textToSpeechPermission\":\"ALLOWED\",\"epub\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.com/books/download/Shizuko_Kuroha_s_Japanese_Patchwork_Quil-sample-epub.acsm?id=WiqODwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"pdf\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.com/books/download/Shizuko_Kuroha_s_Japanese_Patchwork_Quil-sample-pdf.acsm?id=WiqODwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"webReaderLink\":\"http://play.google.com/books/reader?id=WiqODwAAQBAJ&hl=&source=gbs_api\",\"accessViewStatus\":\"SAMPLE\",\"quoteSharingAllowed\":false},\"searchInfo\":{\"textSnippet\":\"This book brings a fresh eye to classic patchwork patterns in a way that is delighting quilters all around the world today.\"}},{\"kind\":\"books#volume\",\"id\":\"5yfWswEACAAJ\",\"etag\":\"f8AMw+mPK8E\",\"selfLink\":\"https://www.googleapis.com/books/v1/volumes/5yfWswEACAAJ\",\"volumeInfo\":{\"title\":\"Explore Walking Foot Quilting with Leah Day\",\"authors\":[\"Leah Day\"],\"publishedDate\":\"2017\",\"description\":\"Ready for a machine quilting adventure? It's time to explore walking foot machine quilting with Leah Day! Specifically designed for quilting on a home machine, this style uses a walking foot to evenly feed the layers of your quilt to produce beautiful quilting stitches. Learn how to quilt thirty designs in seven quilt projects.\",\"industryIdentifiers\":[{\"type\":\"ISBN_10\",\"identifier\":\"0997901144\"},{\"type\":\"ISBN_13\",\"identifier\":\"9780997901146\"}],\"readingModes\":{\"text\":false,\"image\":false},\"pageCount\":152,\"printType\":\"BOOK\",\"categories\":[\"Machine quilting\"],\"maturityRating\":\"NOT_MATURE\",\"allowAnonLogging\":false,\"contentVersion\":\"preview-1.0.0\",\"panelizationSummary\":{\"containsEpubBubbles\":false,\"containsImageBubbles\":false},\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=5yfWswEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=5yfWswEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"},\"language\":\"en\",\"previewLink\":\"http://books.google.com/books?id=5yfWswEACAAJ&dq=quilting&hl=&cd=3&source=gbs_api\",\"infoLink\":\"http://books.google.com/books?id=5yfWswEACAAJ&dq=quilting&hl=&source=gbs_api\",\"canonicalVolumeLink\":\"https://books.google.com/books/about/Explore_Walking_Foot_Quilting_with_Leah.html?hl=&id=5yfWswEACAAJ\"},\"saleInfo\":{\"country\":\"US\",\"saleability\":\"NOT_FOR_SALE\",\"isEbook\":false},\"accessInfo\":{\"country\":\"US\",\"viewability\":\"NO_PAGES\",\"embeddable\":false,\"publicDomain\":false,\"textToSpeechPermission\":\"ALLOWED\",\"epub\":{\"isAvailable\":false},\"pdf\":{\"isAvailable\":false},\"webReaderLink\":\"http://play.google.com/books/reader?id=5yfWswEACAAJ&hl=&source=gbs_api\",\"accessViewStatus\":\"NONE\",\"quoteSharingAllowed\":false},\"searchInfo\":{\"textSnippet\":\"Explore Walking Foot Quilting with Leah Day will help you: - Take your machine quilting up a notch, without the challenges of free motion quilting - Easily decide when to mark quilting designs or confidently skip that step - Get to the root ...\"}},{\"kind\":\"books#volume\",\"id\":\"x9x_DwAAQBAJ\",\"etag\":\"cT1HBDVesvQ\",\"selfLink\":\"https://www.googleapis.com/books/v1/volumes/x9x_DwAAQBAJ\",\"volumeInfo\":{\"title\":\"Simple Geometric Quilting\",\"subtitle\":\"Modern, Minimalist Designs for Throws, Pillows, Wall Decor and More\",\"authors\":[\"Laura Preston\"],\"publisher\":\"Page Street Publishing\",\"publishedDate\":\"2019-08-27\",\"description\":\"Bold Shapes and Clean Lines for Faster Modern Quilting Breathe some fresh air into your quilts with 20 stunning contemporary projects from designer Laura Preston. Using simple shapes and solid colors, Laura’s method streamlines the traditional quilting process for beautiful quilts in less time. Quilt tops come together quickly with large-scale cuts of fabric and as little piecing as possible, making these projects perfect for beginners. Advanced quilters can delve into modern techniques such as creating curved lines and working with negative space rather than intricate quilting blocks. From chic wall hangings to cozy crib-size and queen-size quilts, every project doubles as a work of art. Fueled by her minimalist lifestyle traveling the United States in her Airstream trailer, Laura’s designs reflect the striking landscapes of the American West. The Arches Queen Quilt showcases the dramatic curves found in Arches National Park in Utah. The Lone Pine Pillow, with its range of triangles, was inspired by the Sierra Nevada mountains, and the Sand Dollar Table Runner was sparked by a beach in Big Sur, California. Follow Laura’s insightful design tips, and soon you’ll start to see inspiration everywhere. With illustrated step-by-step instructions and in-depth tutorials, this book is an essential resource for the modern quilter.\",\"industryIdentifiers\":[{\"type\":\"ISBN_13\",\"identifier\":\"9781624148040\"},{\"type\":\"ISBN_10\",\"identifier\":\"1624148042\"}],\"readingModes\":{\"text\":true,\"image\":false},\"pageCount\":160,\"printType\":\"BOOK\",\"categories\":[\"Crafts & Hobbies\"],\"maturityRating\":\"NOT_MATURE\",\"allowAnonLogging\":true,\"contentVersion\":\"1.4.4.0.preview.2\",\"panelizationSummary\":{\"containsEpubBubbles\":false,\"containsImageBubbles\":false},\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=x9x_DwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=x9x_DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"},\"language\":\"en\",\"previewLink\":\"http://books.google.com/books?id=x9x_DwAAQBAJ&printsec=frontcover&dq=quilting&hl=&cd=4&source=gbs_api\",\"infoLink\":\"https://play.google.com/store/books/details?id=x9x_DwAAQBAJ&source=gbs_api\",\"canonicalVolumeLink\":\"https://play.google.com/store/books/details?id=x9x_DwAAQBAJ\"},\"saleInfo\":{\"country\":\"US\",\"saleability\":\"FOR_SALE\",\"isEbook\":true,\"listPrice\":{\"amount\":9.99,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amount\":9.99,\"currencyCode\":\"USD\"},\"buyLink\":\"https://play.google.com/store/books/details?id=x9x_DwAAQBAJ&rdid=book-x9x_DwAAQBAJ&rdot=1&source=gbs_api\",\"offers\":[{\"finskyOfferType\":1,\"listPrice\":{\"amountInMicros\":9990000,\"currencyCode\":\"USD\"},\"retailPrice\":{\"amountInMicros\":9990000,\"currencyCode\":\"USD\"},\"giftable\":true}]},\"accessInfo\":{\"country\":\"US\",\"viewability\":\"PARTIAL\",\"embeddable\":true,\"publicDomain\":false,\"textToSpeechPermission\":\"ALLOWED\",\"epub\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.com/books/download/Simple_Geometric_Quilting-sample-epub.acsm?id=x9x_DwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"pdf\":{\"isAvailable\":false},\"webReaderLink\":\"http://play.google.com/books/reader?id=x9x_DwAAQBAJ&hl=&source=gbs_api\",\"accessViewStatus\":\"SAMPLE\",\"quoteSharingAllowed\":false},\"searchInfo\":{\"textSnippet\":\"Follow Laura’s insightful design tips, and soon you’ll start to see inspiration everywhere. With illustrated step-by-step instructions and in-depth tutorials, this book is an essential resource for the modern quilter.\"}}]}\n"