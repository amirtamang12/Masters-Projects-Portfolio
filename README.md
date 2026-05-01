# Cisco Network Troubleshooting & Architecture Design

This repository contains a comprehensive networking project utilizing Cisco Packet Tracer. The project is divided into two phases: troubleshooting an existing broken network and architecting a new, expanded network topology from scratch.

## Overview

The primary objective of this project is to demonstrate practical skills in configuring, routing, and securing Cisco networking equipment. It showcases the ability to diagnose connectivity issues using CLI commands and implement solutions using Cisco IOS.

## Project Structure

*   **Part A: Network Troubleshooting:** Diagnosing and resolving connectivity issues on existing switches and routers.
*   **Part B: Network Architecture & Configuration:** Designing a new network topology, assigning IP addresses, configuring static routes, and securing device access.

## Key Features & Skills Demonstrated

### 1. Network Troubleshooting (Part A)
*   Diagnosed missing VLAN configurations and successfully implemented them on switches.
*   Resolved routing and IP misconfigurations on router Loopback interfaces.
*   Utilized `show ip interface brief`, `show interface vlan`, and `show ip route` commands to identify faults.
*   Extracted device information including IOS versions, NVRAM, and ROM sizes using the `show version` command.
*   Utilized `traceroute` and `ping` to calculate average round trip times (RTT) across multiple network hops.

### 2. Network Architecture & Routing (Part B)
*   **Topology Design:** Expanded an existing network by integrating an ISP router and establishing serial connections between multiple routers.
*   **IP Addressing:** Subnetted and assigned IPv4 addresses across FastEthernet, GigabitEthernet, and Serial interfaces using `/24` and `/30` subnet masks.
*   **Static Routing:** Configured default routes (`0.0.0.0 0.0.0.0`) to the ISP and established return routes for bidirectional connectivity.
*   **Device Security & Remote Access:**
    *   Secured privileged EXEC mode using `enable secret`.
    *   Configured console and VTY line passwords.
    *   Enabled password encryption (`service password-encryption`).
    *   Set up secure remote access using **SSH** with RSA crypto keys on switches.
    *   Configured **Telnet** access for remote router management.
*   **Verification:** Successfully tested end-to-end connectivity using ping tests between PC-A and PC-B across the routed network.

## Technologies Used

*   **Software:** Cisco Packet Tracer
*   **Devices:** Cisco 1941 Routers, Cisco 2911 Routers, Cisco 2960 Switches, End Devices (PCs)
*   **Protocols Configured:** IPv4, ICMP, SSH, Telnet, Static Routing

## Theoretical Application

The project also includes a brief theoretical analysis of the TCP/IP model, detailing the specific protocols utilized at the Application (HTTP, FTP), Transport (TCP, UDP), Internet (IP, ICMP), and Network Interface (Ethernet, Wi-Fi) layers. It concludes with an analysis of how effective, scalable network design positively impacts social connectivity and environmental sustainability.
