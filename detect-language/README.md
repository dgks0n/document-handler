<p>This is a language detection library implemented in plain Java. (aliases: language identification, language guessing) </p>
<ul>
<li>Presentation : <a href="http://www.slideshare.net/shuyo/language-detection-library-for-java" rel="nofollow">http://www.slideshare.net/shuyo/language-detection-library-for-java</a> </li>
<li><a href="/p/language-detection/wiki/ProjectHomeJa">ProjectHomeJa</a> : Project Home in Japanese </li>
</ul>
<h1><a name="Abstract"></a>Abstract<a href="#Abstract" class="section_anchor"></a></h1>
<ul>
<li>Generate language profiles from Wikipedia abstract xml </li>
<li>Detect language of a text using naive Bayesian filter </li>
<li>99% over precision for 53 languages </li>
</ul>
<h1><a name="News"></a>News<a href="#News" class="section_anchor"></a></h1>
<ul>
<li>01/12/2012 </li>
<ul>
<li>Migrate the repository of language-detection from subversion into git </li>
<ul>
<li>for Maven support </li>
</ul>
</ul>
<li>09/13/2011 </li>
<ul>
<li>Add language profile of Estonian, Lithuanian, Latvian and Slovene. </li>
<li>Support retrieving a list of loaded language profiles as getLangList() ( <a title="No way to get list of languages supported" class=closed_ref href="/p/language-detection/issues/detail?id=20">&nbsp;issue 20&nbsp;</a> ) </li>
<li>support generating a language profile from plain text ( <a title="Non Wikipedia corpus for profile generation" class=closed_ref href="/p/language-detection/issues/detail?id=23">&nbsp;issue 23&nbsp;</a> ) </li>
<li>Fixed a bug of <a title="Profile generation problem" class=closed_ref href="/p/language-detection/issues/detail?id=21">&nbsp;issue 21&nbsp;</a>. </li>
</ul>
<li>02/02/2011 </li>
<ul>
<li>fixed bugs (no profile directory / long text detectation)  </li>
</ul>
<li>01/24/2011 </li>
<ul>
<li>4x faster detection (thanks to <a href="http://code.google.com/u/elmer.garduno/" rel="nofollow">elmer.garduno</a>) </li>
</ul>
<li>12/22/2010 </li>
<ul>
<li>Support Apache Nutch&#x27;s plugin </li>
</ul>
<li>11/18/2010 </li>
<ul>
<li>Provide a package file. </li>
</ul>
</ul>
<h1><a name="Requires"></a>Requires<a href="#Requires" class="section_anchor"></a></h1>
<ul>
<li>Java 1.6 </li>
<li>JSONIC (bundled) &lt; <a href="http://sourceforge.jp/projects/jsonic/devel/" rel="nofollow">http://sourceforge.jp/projects/jsonic/devel/</a> , Apache License 2.0</li>
</ul>
