{ pkgs ? import <nixpkgs> {} }:
  pkgs.mkShell {
    # See https://nixos.wiki/wiki/Development_environment_with_nix-shell for a quickstart on setting up virtual environments with nix and direnv

    # EDIT: Turns out you don't need to prepend the package name with pkg.buildPackages.<package>
    # Also, to find out what packages are available for use, https://search.nixos.org
    nativeBuildInputs = [ pkgs.ruby
                          pkgs.swiProlog
                          pkgs.openjdk11 
                          pkgs.postgresql_13 ]; # io lang package does not support osX, use "brew install io" instead
}
