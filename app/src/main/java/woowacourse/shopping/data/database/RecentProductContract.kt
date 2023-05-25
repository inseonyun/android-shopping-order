package woowacourse.shopping.data.database

import android.provider.BaseColumns
import woowacourse.shopping.data.model.Server

object RecentProductContract {
    fun getCreateSQL(server: Server): String {
        val tableName =
            when (server) {
                Server.BASE_URL_JENNA -> {
                    server.name.substringAfterLast("URL_").lowercase()
                }
                Server.BASE_URL_POI -> {
                    server.name.substringAfterLast("URL_").lowercase()
                }
                Server.BASE_URL_TORI -> {
                    server.name.substringAfterLast("URL_").lowercase()
                }
            }
        return "CREATE TABLE IF NOT EXISTS $tableName (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${RecentProduct.PRODUCT_ID} INTEGER UNIQUE," +
            "${RecentProduct.CREATE_DATE} TEXT)"
    }

    fun getDropSQL(server: Server): String {
        return "DROP TABLE IF EXISTS ${getTableName(server)}"
    }

    fun getTableName(server: Server): String =
        when (server) {
            Server.BASE_URL_JENNA -> {
                server.name.substringAfterLast("URL_").lowercase()
            }
            Server.BASE_URL_POI -> {
                server.name.substringAfterLast("URL_").lowercase()
            }
            Server.BASE_URL_TORI -> {
                server.name.substringAfterLast("URL_").lowercase()
            }
        }

    object RecentProduct : BaseColumns {
        const val PRODUCT_ID = "ProductId"
        const val CREATE_DATE = "CreateDate"
    }
}
