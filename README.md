
<!-- PROJECT LOGO 
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>
-->
<h3 align="center">Api-football-wrapper</h3>
<div>
  <p align="center">
    An unofficial wrapper for Api-football & Api-Sports! (Work in progress)
    <br />
    <a href="https://www.api-football.com/sports"><strong>Explore official api docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/baleDevIt/api-football-wrapper/">Usage example</a>
    ·
    <a href="https://github.com/baleDevIt/api-football-wrapper/issues">Report Bug</a>
    ·
    <a href="https://github.com/baleDevIt/api-football-wrapper/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<!--[![Product Name Screen Shot][product-screenshot]](https://example.com)-->

There are several examples, for the major programming languages, which illustrate an example call for the use of the API of the api-football.com service within the official documentation.

The creation of this project was born from the need to:
* Simplify the use of this service 
* Format the information coming from the requests simplifying the management

This project aims to allow the easy use of the information requested and received through this service and the implementation in other projects.


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* Add Maven dependency in your project
   ```xml
   <dependency>
        <groupId>it.gbale.apisports.apifootball</groupId>
        <artifactId>apisports-apifootball</artifactId>
        <version>1.0</version>
   </dependency>
   ```

### Installation

1. Get a free or paid API Key at [https://www.api-football.com/sports](https://www.api-football.com/sports) for more information see [https://www.api-football.com/documentation-v3#section/Authentication](https://www.api-football.com/documentation-v3#section/Authentication)
2. Create an instance of ApiSports and insert your token
   ```java
    ApiFootball apiFootball = new ApiFootball("Token");   
   ```


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Example Section](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Support endpoints API-FOOTBALL
- [ ] Support endpoints API-BASKETBALL
- [ ] Support endpoints API-BASEBALL
- [ ] Support endpoints API-FORMULA-1
- [ ] Support endpoints API-HANDBALL
- [ ] Support endpoints API-HOCKEY
- [ ] Support endpoints API-NBA
- [ ] Support endpoints API-AMERICAN-FOOTBALL
- [ ] Support endpoints API-RUGBY
- [ ] Support endpoints API-VOLLEYBALL

See the [open issues](https://github.com/baleDevIt/api-football-wrapper/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.md` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
