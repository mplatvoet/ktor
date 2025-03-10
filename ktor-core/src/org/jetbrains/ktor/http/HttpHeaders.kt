package org.jetbrains.ktor.http

public object HttpHeaders {
    // Permanently registered standard HTTP headers
    // The list is taken from http://www.iana.org/assignments/message-headers/message-headers.xml#perm-headers

    val Accept = "Accept"
    val AcceptCharset = "Accept-Charset"
    val AcceptEncoding = "Accept-Encoding"
    val AcceptLanguage = "Accept-Language"
    val AcceptRanges = "Accept-Ranges"
    val Age = "Age"
    val Allow = "Allow"
    val ALPN = "ALPN" // Application-Layer Protocol Negotiation, HTTP/2
    val AuthenticationInfo = "Authentication-Info"
    val Authorization = "Authorization"
    val CacheControl = "Cache-Control"
    val Connection = "Connection"
    val ContentDisposition = "Content-Disposition"
    val ContentEncoding = "Content-Encoding"
    val ContentLanguage = "Content-Language"
    val ContentLength = "Content-Length"
    val ContentLocation = "Content-Location"
    val ContentRange = "Content-Range"
    val ContentType = "Content-Type"
    val Cookie = "Cookie"
    val DASL = "DASL" // WebDAV Search
    val Date = "Date"
    val DAV = "DAV" // WebDAV
    val Depth = "Depth" // WebDAV
    val Destination = "Destination"
    val ETag = "ETag"
    val Expect = "Expect"
    val Expires = "Expires"
    val From = "From"
    val Host = "Host"
    val HTTP2Settings = "HTTP2-Settings"
    val If = "If"
    val IfMatch = "If-Match"
    val IfModifiedSince = "If-Modified-Since"
    val IfNoneMatch = "If-None-Match"
    val IfRange = "If-Range"
    val IfScheduleTagMatch = "If-Schedule-Tag-Match"
    val IfUnmodifiedSince = "If-Unmodified-Since"
    val LastModified = "Last-Modified"
    val Location = "Location"
    val LockToken = "Lock-Token"
    val MaxForwards = "Max-Forwards"
    val MIMEVersion = "MIME-Version"
    val OrderingType = "Ordering-Type"
    val Origin = "Origin"
    val Overwrite = "Overwrite"
    val Position = "Position"
    val Pragma = "Pragma"
    val Prefer = "Prefer"
    val PreferenceApplied = "Preference-Applied"
    val ProxyAuthenticate = "Proxy-Authenticate"
    val ProxyAuthenticationInfo = "Proxy-Authentication-Info"
    val ProxyAuthorization = "Proxy-Authorization"
    val PublicKeyPins = "Public-Key-Pins"
    val PublicKeyPinsReportOnly = "Public-Key-Pins-Report-Only"
    val Range = "Range"
    val Referrer = "Referer"
    val RetryAfter = "Retry-After"
    val ScheduleReply = "Schedule-Reply"
    val ScheduleTag = "Schedule-Tag"
    val SecWebSocketAccept = "Sec-WebSocket-Accept"
    val SecWebSocketExtensions = "Sec-WebSocket-Extensions"
    val SecWebSocketKey = "Sec-WebSocket-Key"
    val SecWebSocketProtocol = "Sec-WebSocket-Protocol"
    val SecWebSocketVersion = "Sec-WebSocket-Version"
    val Server = "Server"
    val SetCookie = "Set-Cookie"
    val SLUG = "SLUG" // Atom Publishing
    val StrictTransportSecurity = "Strict-Transport-Security"
    val TE = "TE"
    val Timeout = "Timeout"
    val Trailer = "Trailer"
    val TransferEncoding = "Transfer-Encoding"
    val Upgrade = "Upgrade"
    val UserAgent = "User-Agent"
    val Vary = "Vary"
    val Via = "Via"
    val Warning = "Warning"
    val WWWAuthenticate = "WWW-Authenticate"

    val MultiValueHeaders = listOf(
            Accept,
            AcceptCharset,
            AcceptEncoding,
            AcceptLanguage,
            TE,
            Via
                                  )

}

fun splitKnownHeaders(key: String, value: String): List<String> {
    if (key in HttpHeaders.MultiValueHeaders) {
        return value.split(",").map { it.trim() }
    }
    return listOf(value)
}
