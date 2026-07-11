/* side-menu.js — deployable left-side navigation drawer for the Wodel website,
 * shaped after the Gotten website drawer: brand panel with logo tile, tagline
 * and action pills, section labels, and icon-led option rows.
 *
 * Self-contained, dependency-free. At page load it reads the page's own
 * .page-header (logo, tagline and every .btn link) and builds:
 *   - a fixed round toggle button at the top-left of the viewport,
 *   - a left drawer (aside.side-menu) in the Gotten drawer layout,
 *   - a dark overlay behind the drawer.
 * "Update site" and "View on GitHub" links (when the page has them) are
 * promoted to brand action pills; the remaining links are grouped under
 * "Explore" (pages) and "Downloads" (packages) with a Material icon each.
 * Dismiss with the close button, the overlay, the Escape key, or a link.
 */
(function () {
  "use strict";

  /* Material Icons font (same family used by the Gotten drawer). */
  (function loadIcons() {
    if (document.querySelector('link[href*="family=Material+Icons"]')) { return; }
    var l = document.createElement("link");
    l.rel = "stylesheet";
    l.href = "https://fonts.googleapis.com/icon?family=Material+Icons";
    document.head.appendChild(l);
  })();

  /* keyword -> Material icon; first match wins, order matters. */
  var ICON_RULES = [
    [/video/i, "tv"],
    [/sgame/i, "videogame_asset"],
    [/evaluation/i, "assessment"],
    [/exercis/i, "assignment"],
    [/wodel-edu/i, "school"],
    [/wodel-test/i, "bug_report"],
    [/get started/i, "play_arrow"],
    [/github/i, "code"],
    [/update site/i, "download"],
    [/standalone/i, "settings"],
    [/virtualbox|\bvm\b/i, "computer"],
    [/\.zip|\.tar|download/i, "archive"],
    [/sample/i, "apps"],
    [/automata/i, "timeline"],
    [/asple/i, "translate"],
    [/security/i, "security"],
    [/uml/i, "device_hub"],
    [/bpel/i, "call_split"],
    [/bpmn/i, "linear_scale"],
    [/logic/i, "memory"],
    [/wodel$/i, "home"]
  ];
  var DOWNLOAD_RULES = /update site|standalone|virtualbox|\bvm\b|\.zip|\.tar|download/i;

  function iconFor(label) {
    for (var i = 0; i < ICON_RULES.length; i++) {
      if (ICON_RULES[i][0].test(label)) { return ICON_RULES[i][1]; }
    }
    return "chevron_right";
  }

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
    var titleText = titleLink ? (titleLink.textContent || "").replace(/\s+/g, " ").trim() : "";
    var tagline = header.querySelector(".project-tagline");
    var buttons = Array.prototype.slice.call(header.querySelectorAll("a.btn"));
    if (!buttons.length) { return; }

    var here = window.location.href.split("#")[0].split("?")[0]
      .replace(/index\.html$/, "").replace(/\/$/, "");
    function norm(u) {
      return u.split("#")[0].split("?")[0].replace(/index\.html$/, "").replace(/\/$/, "");
    }
    function label(btn) {
      return (btn.textContent || "").replace(/\s+/g, " ").trim();
    }

    /* Promote Update site + GitHub to brand action pills when present. */
    var updateBtn = null, githubBtn = null, rest = [];
    buttons.forEach(function (btn) {
      var t = label(btn);
      if (!updateBtn && /update site/i.test(t)) { updateBtn = btn; }
      else if (!githubBtn && /github/i.test(t)) { githubBtn = btn; }
      else { rest.push(btn); }
    });

    var explore = [], downloads = [];
    rest.forEach(function (btn) {
      (DOWNLOAD_RULES.test(label(btn)) ? downloads : explore).push(btn);
    });

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

    /* brand panel (Gotten layout: close, logo tile, tagline, action pills) */
    var brand = document.createElement("div");
    brand.className = "side-menu-brand";

    var close = document.createElement("button");
    close.className = "side-menu-close";
    close.type = "button";
    close.setAttribute("aria-label", "Close navigation menu");
    close.title = "Close menu";
    close.innerHTML = '<i class="material-icons" aria-hidden="true">close</i>';
    brand.appendChild(close);

    if (titleLink && logoImg) {
      var lockRow = document.createElement("p");
      lockRow.className = "side-menu-lockup-row";
      var homeA = document.createElement("a");
      homeA.className = "side-menu-lockup";
      homeA.href = titleLink.href;
      homeA.setAttribute("aria-label", (titleText || "Home") + " home");
      var img = document.createElement("img");
      img.src = logoImg.src;
      img.alt = titleText ? titleText + " logo" : "Logo";
      homeA.appendChild(img);
      lockRow.appendChild(homeA);
      brand.appendChild(lockRow);
    }

    if (tagline) {
      var tg = document.createElement("p");
      tg.className = "side-menu-tagline";
      tg.textContent = (tagline.textContent || "").replace(/\s+/g, " ").trim();
      brand.appendChild(tg);
    }

    if (updateBtn || githubBtn) {
      var actions = document.createElement("div");
      actions.className = "side-menu-actions";
      if (updateBtn) {
        var ua = document.createElement("a");
        ua.className = "side-menu-btn side-menu-btn--solid";
        ua.href = updateBtn.href;
        if (updateBtn.target) { ua.target = updateBtn.target; }
        ua.textContent = "Update site";
        actions.appendChild(ua);
      }
      if (githubBtn) {
        var ga = document.createElement("a");
        ga.className = "side-menu-btn side-menu-btn--flat";
        ga.href = githubBtn.href;
        ga.target = "_blank";
        ga.rel = "noopener";
        ga.textContent = "GitHub";
        actions.appendChild(ga);
      }
      brand.appendChild(actions);
    }
    menu.appendChild(brand);

    /* option rows: icon + label, grouped under section labels */
    var nav = document.createElement("nav");
    nav.className = "side-menu-nav";
    var list = document.createElement("ul");

    function addSection(name, items) {
      if (!items.length) { return; }
      var li = document.createElement("li");
      li.className = "side-menu-label";
      li.textContent = name;
      list.appendChild(li);
      items.forEach(function (btn) {
        var t = label(btn);
        var item = document.createElement("li");
        var a = document.createElement("a");
        a.href = btn.href;
        if (btn.target) { a.target = btn.target; }
        if (btn.target === "_blank") { a.rel = "noopener"; }
        var ic = document.createElement("i");
        ic.className = "material-icons";
        ic.setAttribute("aria-hidden", "true");
        ic.textContent = iconFor(t);
        a.appendChild(ic);
        a.appendChild(document.createTextNode(t));
        if (norm(btn.href) === here) { a.className = "is-active"; }
        item.appendChild(a);
        list.appendChild(item);
      });
    }
    addSection("Explore", explore);
    addSection("Downloads", downloads);

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
      if (lastFocus && typeof lastFocus.focus === "function") { lastFocus.focus(); }
      else { toggle.focus(); }
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
      while (t && t !== nav) {
        if (t.tagName === "A") { closeMenu(); break; }
        t = t.parentNode;
      }
    });
  });
})();
