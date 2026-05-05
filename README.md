# VeriChain LE: Blockchain-Powered Fake Social Media Profile Investigation Platform

## 🔴 LIVE DEMO

**Access the live demonstration here:**
## 🌐 https://siva20shree.github.io/blockchain-FakeID-investigation-

### 📸 Application Screenshot

![VeriChain LE Dashboard](Screenshot%202026-05-05%20160541.png)

---

## A Research Platform for Law Enforcement & Digital Forensics

---

## 1. Abstract

This research project presents **VeriChain LE**, a blockchain-based investigation platform designed to identify, verify, and counter fake social media profiles used for disinformation, fraud, and criminal coordination. The platform integrates permissioned blockchain technology with Decentralized Identifiers (DIDs), Verifiable Credentials (VCs), and Zero-Knowledge Proofs (ZKPs) to provide immutable verification trails and privacy-preserving authentication suitable for law enforcement investigations.

---

## 2. Problem Statement

### The Challenge
- **Fake profiles** are used for disinformation campaigns, financial fraud, and criminal coordination
- Law enforcement agencies need **immutable verification trails** for court admissibility
- Current tools lack **chain-of-custody** mechanisms for digital evidence
- Privacy concerns when verifying investigative attributes without exposing PII

### Research Objectives
1. Develop a blockchain-based system for profile authenticity verification
2. Implement Zero-Knowledge Proofs for privacy-preserving verification
3. Create court-admissible evidence with cryptographic chain-of-custody
4. Build an operational dark-mode UI optimized for 24/7 operations centers

---

## 3. System Architecture

### 3.1 Blockchain Layer

```
┌─────────────────────────────────────────────────────────────┐
│                  PERMISSIONED BLOCKCHAIN                     │
│              (Hyperledger Fabric 3.0)                     │
├─────────────────────────────────────────────────────────────┤
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │  Regional   │  │   Federal    │  │ Prosecutor  │     │
│  │    LEAs     │──│   Task Force │──│   Office    │     │
│  └──────────────┘  └──────────────┘  └──────────────┘     │
│                                                             │
│  Channel: Private per-case channels                        │
│  Consensus: Raft (standard) / PBFT (evidence)            │
└─────────────────────────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│      PUBLIC CHAIN ANCHOR (Ethereum/Polygon)                 │
│      Periodic hash anchors for immutability               │
└─────────────────────────────────────────────────────────────┘
```

### 3.2 Smart Contracts

| Contract | Purpose |
|----------|--------|
| `ProfileRegistryContract` | Register and verify social profiles with DID |
| `EvidenceContract` | Immutable evidence locking with SHA-256 hashes |
| `CredentialContract` | Issue Verifiable Credentials (VCs) |
| `AccessControlContract` | RBAC + ABAC authorization |

### 3.3 Decentralized Identifiers (DIDs)

Per W3C DID v1.1 specification:
```
did:verichain:le:<platform>:<unique-hash>
```

Example: `did:verichain:le:twitter:e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855`

### 3.4 Zero-Knowledge Proofs (ZKPs)

- **Implementation**: zk-STARKs (post-quantum secure, no trusted setup)
- **Use Cases**:
  - Verify investigator authorization without revealing credentials
  - Confirm risk threshold without exposing behavioral analysis
  - Validate chain-of-custody without case details

---

## 4. Technical Implementation

### 4.1 Technology Stack

| Component | Technology |
|-----------|------------|
| Backend | Spring Boot 3.2.1 (Java 17) |
| Blockchain | Hyperledger Fabric 3.0 |
| Cryptography | Ed25519 (signing), SHA-3 (hashing), AES-256-GCM |
| ZKPs | zk-STARKs |
| DID/VC | W3C DID v1.1, VC Data Model 2.0 |
| Frontend | HTML5/CSS3 (Tactical Dark Mode) |

### 4.2 API Endpoints (Research Demo)

```
GET  /api/dashboard/stats      → Statistics
GET  /api/dashboard/activity → Activity feed  
GET  /api/investigations      → Investigation list
GET  /api/evidence          → Evidence list
POST /api/scanner/scan      → Profile analysis
```

### 4.3 Data Models

**Investigation**
```json
{
  "id": "CASE-2024-0847",
  "profile": "@crypto_king_999",
  "platform": "twitter",
  "risk": 87,
  "status": "threat",
  "date": "2024-01-15"
}
```

**Evidence Lock**
```json
{
  "id": "EV-8A3F2C",
  "profile": "@crypto_king_999",
  "hash": "a7f3b2c1...",
  "investigator": "J. Doe",
  "timestamp": "2024-01-15T14:32:00Z"
}
```

### 4.4 Fake ID Detection Criteria

The system analyzes social media profiles against these **6 key indicators** to detect fake profiles:

| # | Criteria | Description | Risk Weight |
|---|----------|-------------|-------------|
| 1 | **Sudden Follower Increase** | Abnormal spike in followers within short time | HIGH |
| 2 | **Profile Name/Picture Changes** | Frequent username or avatar modifications | MEDIUM |
| 3 | **Sudden Post Increase** | Unusual posting frequency (dozens per hour) | HIGH |
| 4 | **AI-Generated Images** | Detection of synthetic profile pictures using AI detection | CRITICAL |
| 5 | **Mass Message Forwarding** | Same message forwarded simultaneously to multiple users | HIGH |
| 6 | **Follower Ratio Anomaly** | Drastic changes in followers/following ratio | MEDIUM |

**Detection Algorithm:**
```json
{
  "riskScore": "weighted_average(follower_spike + picture_changes + post_rate + ai_detection + message_flood + ratio_anomaly)",
  "thresholds": {
    "verified": "< 30",
    "warning": "30-60", 
    "threat": "> 60"
  }
}
```

---

## 5. Research Contributions

### 5.1 Novel Features

1. **Hybrid Blockchain Architecture**: Permissioned (Hyperledger Fabric) + public anchors for immutability
2. **ZKP-based Privacy**: Attribute verification without PII exposure
3. **Multi-dimensional Chain-of-Custody**: Inspired by ZAKON framework with admissibility checking
4. **Tactical Dark Mode UI**: WCAG AA compliant for 24/7 operations centers

### 5.2 Performance Metrics (Expected)

| Metric | Target |
|-------|--------|
| Throughput | 8,000+ TPS |
| Evidence Latency | < 2 seconds |
| Query Latency | < 500ms |
| ZKP Proof Size | ~100KB |

---

## 6. Operational Workflow

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│ Onboarding  │───▶│   Profile  │───▶│  Risk      │───▶│ Evidence   │
│             │    │   Scan      │    │  Scoring   │    │  Locking   │
└─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘
                                                             │
                                                             ▼
                                               ┌─────────────────────┐
                                               │ Report Generation   │
                                               │ (Court-Admissible)  │
                                               └─────────────────────┘
```

### Chain-of-Custody Process
1. Investigator authenticates (smart card + ZKP)
2. Profile scanned → behavioral analysis
3. Risk computed → factor breakdown
4. Evidence locked to blockchain → SHA-3 hash
5. Chain-of-custody VC issued
6. Report generated with cryptographic verification

---

## 7. Privacy & Security

### 7.1 Encryption Standards
- **Data at Rest**: AES-256-GCM
- **Data in Transit**: TLS 1.3
- **Signing**: Ed25519 (ephemeral), Ed448 (long-term)
- **Hashing**: SHA-3 (Keccak)

### 7.2 Access Control
- **RBAC**: Lead Investigator, Investigator, Analyst, Prosecutor, Admin
- **ABAC**: Time-limited tokens, case-specific clearance, device restrictions

### 7.3 Risk Mitigation
| Attack Vector | Mitigation |
|--------------|------------|
| Platform API Manipulation | Multi-source verification |
| Insider Collusion | Multi-party authorization |
| Evidence Tampering | Blockchain immutability |
| Privacy Breaches | ZKP verification |
| Sybil Attacks | DID-based identity |

---

## 8. Running the Research Demo

### Prerequisites
- Java 17 (Eclipse Temurin)
- Maven 3.9+
- Web browser

### Build & Run
```bash
# Build the application
mvn clean package -DskipTests

# Run the server
mvn spring-boot:run

# Access the dashboard
open http://localhost:8080/dashboard.html
```

### REST API Testing
```bash
# Get statistics
curl http://localhost:8080/api/dashboard/stats

# Get investigations  
curl http://localhost:8080/api/investigations

# Scan a profile
curl -X POST http://localhost:8080/api/scanner/scan \
  -H "Content-Type: application/json" \
  -d '{"profile":"@example","platform":"twitter"}'
```

---

## 9. Related Research

### Academic References
1. **ZAKON Framework** - Blockchain for digital forensic admissibility (Hyperledger Fabric)
2. **W3C DID v1.1** - Decentralized Identifiers specification
3. **W3C VC Data Model 2.0** - Verifiable Credentials
4. **zk-STARKs** - Zero-knowledge proofs (post-quantum security)
5. **Hyperledger Fabric** - Permissioned blockchain for enterprise

### Related Papers
- Kumar et al. (2021) - IoF-based multi-layer architecture
- Jeong et al. - Digital Evidence Management on Hyperledger Fabric
- Chalkias et al. (2025) - Zero-knowledge Authenticators for Blockchain

---

## 10. Conclusion

This research platform demonstrates the feasibility of applying blockchain technology, decentralized identifiers, and zero-knowledge proofs to law enforcement investigations of fake social media profiles. The system provides:

- **Immutable verification trails** for court admissibility
- **Privacy-preserving authentication** via ZKPs
- **Operational dark-mode UI** optimized for 24/7 centers
- **Chain-of-custody mechanisms** for evidence integrity

Future work will explore integration with actual social media platform APIs and formal verification of smart contracts.

---

## License

This research code is provided for academic purposes.

## Authors

VeriChain LE Research Team
- Lead Investigator: Sivashree N
- Blockchain Architect: Ramyadharshini R

## Contact

For research inquiries: research@verichain.edu