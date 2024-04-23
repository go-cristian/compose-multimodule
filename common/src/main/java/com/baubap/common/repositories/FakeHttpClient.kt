package com.baubap.common.repositories

import com.baubap.common.Response

// Assume this simple interface is a part of a real HTTP client implementation, returning always a
// JSON String response
interface HttpClient {
    suspend fun get(path: String, params: Map<String, String> = emptyMap()): Response<String>
    suspend fun post(path: String, params: Map<String, String> = emptyMap()): Response<String>

    class Fake : HttpClient {

        override suspend fun get(path: String, params: Map<String, String>): Response<String> {
            return Response.Success("")
        }

        override suspend fun post(path: String, params: Map<String, String>): Response<String> {
            return Response.Success("")
        }
    }
}

