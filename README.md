
This is a demo fork of F-Droid to serve as an example app built on the
development fork of Conscrypt which supports TLS Encrypted ClientHello (ECH).
ECH is the next version of the TLS protocol that encrypts internet traffic and
puts the "S" in HTTPS.  It makes it possible to encrypt all of the metadata that
is possible to encrypt in the TLS negogiation. It is a test case for
interoperability between various implementations, platforms, and networks.

The Encrypted ClientHello (ECH) mechanism (IETF draft spec) is a way to plug a
few privacy-holes that remain in the Transport Layer Security (TLS) protocol
that's used as the security layer for the web. OpenSSL is a widely used library
that provides an implementation of the TLS protocol. The DEfO project is
developing an implementation of ECH for OpenSSL, and various clients and servers
that use OpenSSL as a demonstration and for interoperability testing.

DEfO was initially funded by the Open Technology Fund, and subsequently by the
National Democratic Initiative. Tolerant Networks Ltd. and people from the
Guardian Project are doing the work in DEfO.
