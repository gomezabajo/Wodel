/* side-menu.js — deployable left-side navigation drawer for the Wodel website.
 *
 * Self-contained, dependency-free. At page load it reads the page's own
 * .page-header (logo, title, tagline and every .btn link) and builds:
 *   - a fixed round toggle button at the top-left of the viewport,
 *   - a left drawer (aside.side-menu) listing all the header links,
 *   - a dark overlay behind the drawer.
 * The drawer can be dismissed with the close button, the overlay, the Escape
 * key, or by following a link. The link matching the current page is
 * highlighted. No existing markup, styles or scripts are modified.
 */
(function () {
  "use strict";

  function ready(fn) {
    if (document.readyState !== "loading") { fn(); }
    else { document.addEventListener("DOMContentLoaded", fn); }
  }

  ready(function () {
    var header = document.querySelector(".page-header");
    if (!header) { return; }

    /* ---------- harvest the header ---------- */
    var titleLink = header.querySelector(".project-name a");
    var logoImg = titleLink ? titleLink.querySelector("img") : null;
    var titleText = "";
    if (titleLink) {
      titleText = (titleLink.textContent || "").replace(/\s+/g, " ").trim();
    }
    var tagline = header.querySelector(".project-tagline");
    var buttons = header.querySelectorAll("a.btn");
    if (!buttons.length) { return; }

    /* ---------- toggle button ---------- */
    var toggle = document.createElement("button");
    toggle.className = "side-menu-toggle";
    toggle.type = "button";
    toggle.setAttribute("aria-label", "Open navigation menu");
    toggle.setAttribute("aria-expanded", "false");
    toggle.setAttribute("aria-controls", "side-menu");
    toggle.title = "Menu";
    toggle.innerHTML = "<span></span><span></span><span></span>";

    /* ---------- overlay ---------- */
    var overlay = document.createElement("div");
    overlay.className = "side-menu-overlay";
    overlay.setAttribute("aria-hidden", "true");

    /* ---------- drawer ---------- */
    var menu = document.createElement("aside");
    menu.className = "side-menu";
    menu.id = "side-menu";
    menu.setAttribute("role", "navigation");
    menu.setAttribute("aria-label", "Site navigation");
    menu.setAttribute("aria-hidden", "true");

    var top = document.createElement("div");
    top.className = "side-menu-brand";

    var close = document.createElement("button");
    close.className = "side-menu-close";
    close.type = "button";
    close.setAttribute("aria-label", "Close navigation menu");
    close.title = "Close menu";
    close.innerHTML = "&times;";
    top.appendChild(close);

    if (titleLink) {
      var homeA = document.createElement("a");
      homeA.className = "side-menu-home";
      homeA.href = titleLink.href;
      if (logoImg) {
        var tile = document.createElement("span");
        tile.className = "side-menu-logo";
        var img = document.createElement("img");
        img.src = logoImg.src;
        img.alt = titleText ? titleText + " logo" : "Logo";
        tile.appendChild(img);
        homeA.appendChild(tile);
      }
      if (titleText) {
        var t = document.createElement("span");
        t.className = "side-menu-title";
        t.textContent = titleText;
        homeA.appendChild(t);
      }
      top.appendChild(homeA);
    }

    if (tagline) {
      var tg = document.createElement("p");
      tg.className = "side-menu-tagline";
      tg.textContent = (tagline.textContent || "").replace(/\s+/g, " ").trim();
      top.appendChild(tg);
    }
    menu.appendChild(top);

    var nav = document.createElement("nav");
    nav.className = "side-menu-nav";
    var list = document.createElement("ul");

    var here = window.location.href.split("#")[0].split("?")[0]
      .replace(/index\.html$/, "").replace(/\/$/, "");

    Array.prototype.forEach.call(buttons, function (btn) {
      var li = document.createElement("li");
      var a = document.createElement("a");
      a.href = btn.href;
      a.textContent = (btn.textContent || "").replace(/\s+/g, " ").trim();
      if (btn.target) { a.target = btn.target; }
      if (btn.target === "_blank") { a.rel = "noopener"; }
      var linkPath = btn.href.split("#")[0].split("?")[0]
        .replace(/index\.html$/, "").replace(/\/$/, "");
      if (linkPath === here) { a.className = "is-active"; }
      li.appendChild(a);
      list.appendChild(li);
    });
    nav.appendChild(list);
    menu.appendChild(nav);

    document.body.appendChild(toggle);
    document.body.appendChild(overlay);
    document.body.appendChild(menu);

    /* ---------- behaviour ---------- */
    var lastFocus = null;

    function openMenu() {
      lastFocus = document.activeElement;
      document.body.classList.add("side-menu-open");
      menu.setAttribute("aria-hidden", "false");
      toggle.setAttribute("aria-expanded", "true");
      close.focus();
    }

    function closeMenu() {
      document.body.classList.remove("side-menu-open");
      menu.setAttribute("aria-hidden", "true");
      toggle.setAttribute("aria-expanded", "false");
      if (lastFocus && typeof lastFocus.focus === "function") {
        lastFocus.focus();
      } else {
        toggle.focus();
      }
    }

    toggle.addEventListener("click", function () {
      if (document.body.classList.contains("side-menu-open")) { closeMenu(); }
      else { openMenu(); }
    });
    close.addEventListener("click", closeMenu);
    overlay.addEventListener("click", closeMenu);
    document.addEventListener("keydown", function (e) {
      if ((e.key === "Escape" || e.keyCode === 27) &&
          document.body.classList.contains("side-menu-open")) {
        closeMenu();
      }
    });
    nav.addEventListener("click", function (e) {
      var t = e.target;
      if (t && t.tagName === "A") { closeMenu(); }
    });
  });
})();
